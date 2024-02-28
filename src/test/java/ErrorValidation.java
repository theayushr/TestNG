import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorValidation extends Base{

    @Test //(retryAnalyzer = Retry.class)
    public void signInErrors(){

        String email = "ayush3338@mailinator.com";
        String password = "TestNG@3333";

        signInObj.signinUser(email, password);
        Assert.assertEquals("BroIncorrect email or password.", signInObj.getError());
    }
}
