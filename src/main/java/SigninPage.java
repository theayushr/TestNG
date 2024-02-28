import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage extends Abstract{

    WebDriver driver;
    public SigninPage(WebDriver driver){//constructor
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * Page Factory
     */
    //WebElement emailpath = driver.findElement(By.xpath("//input[@id='userEmail']"));
    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement emailpath;
    @FindBy(xpath = "//input[@id='userPassword']")
    WebElement passwordpath;
    @FindBy(xpath = "//input[@id='login']")
    WebElement submit;

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }
    public void signinUser(String email, String password){
        emailpath.sendKeys(email);
        passwordpath.sendKeys(password);
        clickWithWait(submit);
    }

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;

    public String getError(){
        waitToAppear(errorMessage);
        return errorMessage.getText();
    }


}
