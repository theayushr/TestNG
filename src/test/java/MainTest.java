import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainTest extends Base{

    @Test (dataProvider = "sendData")
    public void startTesting(String email, String password) throws InterruptedException {

        ProductPage productObj = new ProductPage(driver);
        CartPage cartObj = new CartPage(driver);
        PaymentPage payObj = new PaymentPage(driver);
        ThankYouPage thankYou = new ThankYouPage(driver);

        signInObj.signinUser(email, password);

        WebElement firstProduct = productObj.getProductByName(Values.productOne);
        WebElement secondProduct = productObj.getProductByName(Values.productTwo);
        WebElement thirdProduct = productObj.getProductByName(Values.productThree);

        productObj.selectProduct(firstProduct);
        productObj.selectProduct(secondProduct);
        productObj.selectProduct(thirdProduct);
        productObj.addToCart();

        cartObj.checkItems(Values.productList);
        cartObj.checkOut();

        payObj.chooseMonthDate(Values.date, Values.month);
        payObj.cvvName(Values.cvv, Values.name, Values.coupon);
        payObj.selectCountry(Values.country);
        payObj.submit();

        thankYou.checkThankYou();
    }

    @Test (dependsOnMethods = "startTesting")
    public void ordersCheck() throws InterruptedException {
                signInObj.signinUser(Values.email, Values.password);
                Header head = new Header(driver);
                Assert.assertTrue(head.checkOrders());
    }

    @DataProvider (name = "sendData")
    public Object[][] sendData() throws IOException {
            // We can also return the Object[][] using HashMaps as well, the users are shown in the course
            // return new Object[][] {{Values.email, Values.password}};
        ReadExcel excel = new ReadExcel();
        return excel.getExcelData();
    }
}

