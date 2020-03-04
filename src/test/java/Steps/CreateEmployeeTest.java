package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class CreateEmployeeTest extends BaseTest {

    @Parameters({"user", "password"})
    @Test(priority = 1)
    @Given("the user login on the CafeTownsend portal")
    public void the_user_login_on_the_CafeTownsend_portal(String user, String password) {

        Cafetownsend.loginpage().CafeLogin(user, password);
    }

    @Test(priority = 2)
    @When("the user clicks on the Create button")
    public void the_user_clicks_on_the_Create_button() {

        Cafetownsend.WaitForElement(Cafetownsend.homePage().Create);
        Cafetownsend.homePage().Create.click();
    }


    @Parameters({"firstname", "lastname", "startdate", "email"})
    @Test(priority = 3)
    @When("the user types the data to create the new employee")
    public void the_user_types_the_data_to_create_the_new_employee(String firstname, String lastname, String startdate, String email) {

        Cafetownsend.employees().AddEmployee(firstname, lastname, startdate, email);
    }

    @Parameters({"firstname", "lastname"})
    @Test(priority = 4)
    @Then("the new employee created is displayed on the employee list")
    public void the_new_employee_created_is_displayed_on_the_employee_list(String firstname, String lastname) {

        Cafetownsend.WaitForElement(Cafetownsend.homePage().HomePageEmployeeList);
        Cafetownsend.homePage().ClickOnTheHomePageEmployee(firstname + " " + lastname);

    }

    @Parameters({"firstname", "lastname", "startdate", "email"})
    @Test(priority = 5)
    @Then("the user validates the employee data was inserted correctly on the CafeTownsend portal")
    public void the_user_validates_the_employee_data_was_inserted_correctly_on_the_CafeTownsend_portal(String firstname, String lastname, String startdate, String email) {

        Cafetownsend.WaitForElement(Cafetownsend.employees().Name);
        Cafetownsend.employees().ValidateInsertedEmployee(firstname, lastname, startdate, email);
        Cafetownsend.WaitForElement(Cafetownsend.homePage().LogoutButton);
        Cafetownsend.homePage().CafeLogout();

    }


}
