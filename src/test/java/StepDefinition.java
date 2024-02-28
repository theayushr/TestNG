import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;


public class StepDefinition extends Base {

    public SigninPage signinObj;
    public MainTest mainObj = new MainTest();
    ProductPage productObj = new ProductPage(driver);
    CartPage cartObj = new CartPage(driver);

    PaymentPage payObj = new PaymentPage(driver);

    ThankYouPage thankYou = new ThankYouPage(driver);


    @Given("I landed on Ecommerce Page")
    public void landed_on_Ecommerce_Page() throws InterruptedException {
        signinObj = goToPage();
    }

    @Given("^Login with username (.+) and password (.+)$")
    public void login_with_username_password(String username, String password) throws InterruptedException {
        signInObj.signinUser(username, password);
        Thread.sleep(3000);
    }

    @When("I add product to the cart")
    public void addtocart() throws InterruptedException {
        Thread.sleep(5000);

//        WebElement firstProduct = productObj.getProductByName("ZARA COAT 3");
//        WebElement secondProduct = productObj.getProductByName("IPHONE 13 PRO");

        productObj.selectProduct(productObj.getProductByName("ZARA COAT 3"));
        Thread.sleep(5000);
        productObj.selectProduct(productObj.getProductByName("IPHONE 13 PRO"));
        Thread.sleep(5000);

        productObj.addToCart();
        Thread.sleep(5000);

        cartObj.checkItems(Values.productList);
        Thread.sleep(5000);
        cartObj.checkOut();
    }

    @And("Checkout and submit the order")
    public void checkOut() throws InterruptedException {
        payObj.chooseMonthDate(Values.date, Values.month);
        payObj.cvvName(Values.cvv, Values.name, Values.coupon);
        payObj.selectCountry(Values.country);
        payObj.submit();
    }

    @Then("ThankYou message is displayed")
    public void verify() throws InterruptedException {
        thankYou.checkThankYou();
    }
}