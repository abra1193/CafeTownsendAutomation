package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class DeleteEmployeeTest extends BaseTest {


    @Parameters({"user", "password"})
    @Test(priority = 1)
    @Given("the user login on the CafeTownsend portal")
    public void the_user_login_on_the_CafeTownsend_portal(String user, String password) {

        Cafetownsend.loginpage().CafeLogin(user, password);
    }

    @Parameters({"newfirstname", "newlastname"})
    @Test(priority = 2)
    @When("the user selects an employee from the employee list")
    public void the_user_selects_an_employee_from_the_employee_list(String newfirstname, String newlastname) {
        Cafetownsend.WaitForElement(Cafetownsend.homePage().HomePageEmployeeList);
        Cafetownsend.homePage().ClickEmployeeOnHomePage(newfirstname + " " + newlastname);
    }

    @Test(priority = 3)
    @And("the user clicks on the Delete button")
    public void theUserClicksOnTheDeleteButton() {
        Cafetownsend.WaitForElement(Cafetownsend.employees().Name);
        Cafetownsend.employees().DeleteButton.click();
    }

    @Parameters({"newfirstname", "newlastname"})
    @Test(priority = 4)
    @Then("the user validates the employee was deleted correctly from the CafeTownsend portal employee list")
    public void theUserValidatesTheEmployeeWasDeletedCorrectlyFromTheCafeTownsendPortalEmployeeList(String newfirstname, String newlastname) {
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        Cafetownsend.WaitForElement(Cafetownsend.homePage().HomePageEmployeeList);
        Cafetownsend.homePage().ValidatedDeletedEmployee(newfirstname + " " + newlastname);
        Cafetownsend.WaitForElement(Cafetownsend.homePage().LogoutButton);
        Cafetownsend.homePage().CafeLogout();
    }
}



