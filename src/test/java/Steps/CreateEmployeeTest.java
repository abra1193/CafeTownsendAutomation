package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Test
public class CreateEmployeeTest extends BaseTest {

    @Test(priority = 1)
    @Given("the user login on the CafeTownsend portal")
    public void the_user_login_on_the_CafeTownsend_portal() {

        Cafetownsend.loginpage().CafeLogin();
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

        Cafetownsend.createEmployee().AddEmployee(firstname, lastname, startdate, email);
    }

    @Test(priority = 4)
    @Then("the new employee created is displayed on the employee list")
    public void the_new_employee_created_is_displayed_on_the_employee_list() {

        Cafetownsend.WaitForElement(Cafetownsend.homePage().LogoutButton);


    }

    @Parameters({"firstname", "lastname"})
    @Test(priority = 5)
    @Then("the user validates the employee data was inserted correctly on the CafeTownsend portal")
    public void the_user_validates_the_employee_data_was_inserted_correctly_on_the_CafeTownsend_portal(String firstname, String lastname) {
        Cafetownsend.WaitForElement(Cafetownsend.homePage().HomePageEmployeeList);
        Cafetownsend.homePage().SelectEmployeeOnHomePage(firstname + " " + lastname);
        Cafetownsend.WaitForElement(Cafetownsend.createEmployee().Name);
        //Cafetownsend.Assert(Cafetownsend.createEmployee().Name.getAttribute("value"),firstname);


    }


}
