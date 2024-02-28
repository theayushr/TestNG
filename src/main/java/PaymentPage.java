import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PaymentPage extends Abstract{

    WebDriver driver;
    public PaymentPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".input.ddl:nth-of-type(1)")
    WebElement monthElement;

    @FindBy(css = ".input.ddl:nth-of-type(2)")
    WebElement dateElement;

    public void chooseMonthDate(String d, String m) throws InterruptedException {
        Thread.sleep(3000);

        Select ms = new Select(monthElement);
        ms.selectByVisibleText(m);

        Select ds = new Select(dateElement);
        ds.selectByVisibleText(d);
    }

    @FindBy(xpath = "(//div/div/input[@class='input txt'])[1]")
    WebElement cvv;
    @FindBy(xpath = "(//div/div/input[@class='input txt'])[2]")
    WebElement name;


    @FindBy(xpath ="//input[@name='coupon']" )
    WebElement coupon;

    public void cvvName(String c, String n, String coup){
        cvv.sendKeys(c);
        name.sendKeys(n);
        coupon.sendKeys(coup);
    }


    @FindBy(xpath = "//input[@placeholder = 'Select Country']")
    WebElement cnt;
    @FindBy(css=".ta-item.list-group-item.ng-star-inserted")
    List<WebElement> countries;

    public void selectCountry(String country) throws InterruptedException {
        cnt.sendKeys(country);

        Thread.sleep(2000);

        for(WebElement co : countries){
            if(co.getText().equals("India")){
                clickWithWait(co);
                break;
            }
        }
    }

    @FindBy(css = ".action__submit")
    WebElement clickSubmit;
    public void submit(){
        clickWithWait(clickSubmit);
    }
}
