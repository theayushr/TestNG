import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java", glue = "", monochrome = true, plugin = {"html:cuc/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests {


}