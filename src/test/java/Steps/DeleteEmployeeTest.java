package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DeleteEmployeeTest extends BaseTest {


    @Parameters({"user", "password"})
    @Test(priority = 1)
    @Given("the user login on the CafeTownsend portal")
    public void the_user_login_on_the_CafeTownsend_portal(String user, String password) {

        Cafetownsend.loginpage().CafeLogin(user, password);
    }

    @Parameters({"firstname", "lastname"})
    @Test(priority = 2)
    @When("the user selects an employee from the employee list")
    public void the_user_selects_an_employee_from_the_employee_list(String firstname, String lastname) {
        Cafetownsend.WaitForElement(Cafetownsend.homePage().HomePageEmployeeList);
        Cafetownsend.homePage().ClickOnTheHomePageEmployee(firstname + " " + lastname);
    }

    @Test(priority = 3)
    @And("the user clicks on the Delete button")
    public void theUserClicksOnTheDeleteButton() {

        Cafetownsend.homePage().Delete.click();
    }

    @Parameters({"firstname", "lastname"})
    @Test(priority = 4)
    @Then("the user validates the employee was deleted correctly from the CafeTownsend portal employee list")
    public void theUserValidatesTheEmployeeWasDeletedCorrectlyFromTheCafeTownsendPortalEmployeeList(String firstname, String lastname) {

        Cafetownsend.WaitForElement(Cafetownsend.homePage().HomePageEmployeeList);
        Cafetownsend.homePage().ValidatedDeletedEmployee(firstname + " " + lastname);
        Cafetownsend.WaitForElement(Cafetownsend.homePage().LogoutButton);
        Cafetownsend.homePage().CafeLogout();
    }
}



