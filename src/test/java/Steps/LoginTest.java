package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest {

    @Test(priority = 1)
    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        Cafetownsend.loginpage().CafeLogin();


    }
    @Test(priority = 2)
    @When("the user types the credentials provided on the portal")
    public void theUserTypesTheCredentialsProvidedOnThePortal() {

        System.out.println("test");
    }
    @Test(priority = 3)
    @Then("the user login on the CafeTownsend Portal successfully")
    public void theUserLoginOnTheCafeTownsendPortalSuccessfully() {

        System.out.println("test");
    }
}
