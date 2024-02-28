import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports{
    public static ExtentReports config(){ //ExtendReports and ExtentSparkReporter

        String path = "/home/sysquare/IdeaProjects/TestNG" + "myreport.html";
        ExtentSparkReporter reporter  = new ExtentSparkReporter(path);

        reporter.config().setReportName("Automation Report");
        reporter.config().setDocumentTitle("Test Cucumber.Reports");

        ExtentReports extent  = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Sysquare");

        return extent;
    }
}
