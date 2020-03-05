package Steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Parameters({"user", "password"})
    @Test(priority = 1)
    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage(String user, String password) {

        Cafetownsend.loginpage().CafeLogin(user, password);


    }

    @Test(priority = 2)
    @When("the user types the credentials provided on the portal")
    public void theUserTypesTheCredentialsProvidedOnThePortal() {

        Cafetownsend.WaitForElement(Cafetownsend.homePage().HomePageEmployeeList);
    }

    @Test(priority = 3)
    @Then("the user login on the CafeTownsend Portal successfully")
    public void theUserLoginOnTheCafeTownsendPortalSuccessfully() {

        Cafetownsend.homePage().CafeLogout();
    }

}