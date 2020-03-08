package Tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {


    @Test(priority = 1)
    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {

        cafetownsend.waitForElement(cafetownsend.loginpage().submitButton);


    }

    @Parameters({"userinvalid", "passwordinvalid"})
    @Test(priority = 2)
    @When("the user types a wrong credentials on the login page")
    public void theUserTypesAWrongCredentialsOnTheLoginPage(String userinvalid, String passwordinvalid) {

        cafetownsend.loginpage().cafeLogIn(userinvalid, passwordinvalid);
    }

    @Test(priority = 3)
    @Then("the portal display a invalid credentials warning on the login page")
    public void thePortalDisplayAInvalidCredentialsWarningOnTheLoginPage() {

        cafetownsend.waitForElement(cafetownsend.loginpage().invalidLoginMessage);
        Assert.assertEquals(cafetownsend.loginpage().invalidLoginMessage.getText(), "Invalid username or password!");
        cafetownsend.waitForElement(cafetownsend.loginpage().submitButton);
    }


}
