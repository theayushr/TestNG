import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ThankYouPage {

    WebDriver driver;
    public ThankYouPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h1[class = 'hero-primary']")
    WebElement confimation;
    public void checkThankYou() throws InterruptedException {
        Thread.sleep(2000);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_UP).build().perform();
        String text = confimation.getText();
        Assert.assertTrue(text.equalsIgnoreCase( "Thankyou for the order."));
        System.out.println(text);
    }
}
