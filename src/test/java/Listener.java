import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener extends Base implements ITestListener {

    ExtentTest test;
    ExtentReports extent = Reports.config();

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }


    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Yeah, Test Passes");
    }

    public void onTestFailure(ITestResult result) {

        test.log(Status.FAIL, "Noh! Test Failed");

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Attach Screenshot
        String filepath = null;
        try {
            filepath = getSS(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

        test.fail(result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }


    public void onStart(ITestContext context) {

    }


    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
