import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Base{

    public WebDriver driver;
    public SigninPage signInObj;

    public WebDriver setDriver(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod
    public SigninPage goToPage() throws InterruptedException {

        driver = setDriver();
        signInObj = new SigninPage(driver);
        signInObj.goTo();

        Thread.sleep(3000);
        return signInObj;
    }

    @AfterMethod (enabled = true)
    public void closeMe(){
        driver.quit();
    }

    public String getSS(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+testCaseName+".png");
//        FileUtils.copyFile(source, file);
        Files.copy(source.toPath(), file.toPath());

        return System.getProperty("user.dir")+testCaseName+".png";
    }
}
