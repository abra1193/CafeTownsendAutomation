package Tests;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {


    @Test(priority = 1)
    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {

        cafetownsend.waitForElement(cafetownsend.loginpage().submitButton);

    }

    @Parameters({"user", "password"})
    @Test(priority = 2)
    @When("the user types the credentials provided on the portal")
    public void theUserTypesTheCredentialsProvidedOnThePortal(String user, String password) {

        cafetownsend.loginpage().cafeLogIn(user, password);
    }

    @Test(priority = 3)
    @Then("the user login on the CafeTownsend Portal successfully")
    public void theUserLoginOnTheCafeTownsendPortalSuccessfully() {

        cafetownsend.waitForElement(cafetownsend.homePage().create);
        Assert.assertEquals(cafetownsend.homePage().greetingsLogin.getText(), "Hello Luke");
        cafetownsend.homePage().cafeLogOut();
        cafetownsend.waitForElement(cafetownsend.loginpage().submitButton);
    }

}