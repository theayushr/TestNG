import java.lang.String;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EndToEnd extends Values{
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        SigninPage signInObj = new SigninPage(driver);
        ProductPage productObj = new ProductPage(driver);
        CartPage cartObj = new CartPage(driver);
        PaymentPage payObj = new PaymentPage(driver);
        ThankYouPage thankYou = new ThankYouPage(driver);
        Header head = new Header(driver);

        signInObj.goTo();
        signInObj.signinUser(email,password);

        WebElement firstProduct = productObj.getProductByName(productOne);
        WebElement secondProduct = productObj.getProductByName(productTwo);
        WebElement thirdProduct = productObj.getProductByName(productThree);

        productObj.selectProduct(firstProduct);
        productObj.selectProduct(secondProduct);
        productObj.selectProduct(thirdProduct);
        productObj.addToCart();

        cartObj.checkItems(productList);
        cartObj.checkOut();

        payObj.chooseMonthDate(date, month);
        payObj.cvvName(cvv, name, coupon);
        payObj.selectCountry(country);
        payObj.submit();

        thankYou.checkThankYou();
        Assert.assertTrue(head.checkOrders());
        driver.quit();
    }
}

