package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LogoutTest extends BaseTest {

    @Parameters({"user", "password"})
    @Test(priority = 1)
    @Given("the user is login on the CafeTownsend Portal")
    public void the_user_is_login_on_the_CafeTownsend_Portal(String user, String password) {

        Cafetownsend.loginpage().CafeLogin(user, password);

    }

    @Test(priority = 2)
    @When("the user clicks on the logout button")
    public void the_user_clicks_on_the_logout_button() {

        Cafetownsend.homePage().WaitForElement(Cafetownsend.homePage().Create);
        Cafetownsend.homePage().LogoutButton.click();


    }

    @Test(priority = 3)
    @Then("the user is logout from the CafeTownsend Portal")
    public void the_user_is_logout_from_the_CafeTownsend_Portal() {

        Cafetownsend.loginpage().WaitForElement(Cafetownsend.loginpage().SubmitButton);
    }


}


