import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Header extends Abstract{

    WebDriver driver;
    public Header(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    SigninPage signInObj = new SigninPage(driver);

    @FindBy(css =".btn.btn-custom[routerlink='/dashboard/myorders']")
    WebElement clickOrder;

    @FindBy(css="tbody td:nth-child(3)")
    List<WebElement> orders;
    public boolean checkOrders() throws InterruptedException {

        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.scrollToElement(clickOrder).build().perform();
        Thread.sleep(2000);
        clickWithWait(clickOrder);
        Thread.sleep(2000);
        for(WebElement item: orders){
            String itemName = item.getText().toUpperCase();
            System.out.println(itemName);
            Assert.assertTrue(Values.productList.contains(itemName));
        }
        return true;
    }

}
