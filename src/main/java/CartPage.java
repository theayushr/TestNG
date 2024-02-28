import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

public class CartPage extends Abstract {

    WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cartWrap h3")
    List<WebElement> cartItems;

    public void checkItems(List<String> productlist) throws InterruptedException {

        Thread.sleep(5000);
        for(WebElement item:cartItems){
            String itemName = item.getText().trim();
            System.out.println(itemName);
            Assert.assertTrue(productlist.contains(itemName));
        }
    }

    @FindBy(css = "li[class='totalRow'] button[type='button']")
    WebElement checkout;

    public void checkOut() throws InterruptedException {

        Actions act = new Actions(driver);
        Thread.sleep(2000);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();

        Thread.sleep(3000);
        clickWithWait(checkout);

/*
       do{
            clickWithWait(checkout);
        }while(invisibility(checkout));
*/
    }
}
