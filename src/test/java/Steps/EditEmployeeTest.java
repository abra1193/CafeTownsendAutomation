package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class EditEmployeeTest extends BaseTest {



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

        Cafetownsend.homePage().ClickEmployeeOnHomePage(firstname + " " + lastname);
    }

    @Test(priority = 3)
    @And("the user clicks on the Edit button")
    public void the_user_clicks_on_the_Edit_button() {
        Cafetownsend.WaitForElement(Cafetownsend.homePage().Edit);
        Cafetownsend.homePage().Edit.click();
        Cafetownsend.WaitForElement(Cafetownsend.employees().BackButton);

    }
    @Parameters({"newfirstname", "newlastname","newstartdate","newemail"})
    @Test(priority = 4)
    @When("the user edits an employee")
    public void the_user_edits_an_employee(String newfirstname,String newlastname,String newstardate,String newemail ) {

        Cafetownsend.employees().EditEmployee(newfirstname, newlastname, newstardate, newemail);

    }
    @Parameters({"newfirstname", "newlastname","newstartdate","newemail"})
    @Test(priority = 5)
    @Then("the user validates the employee data was edited correctly on the CafeTownsend portal")
    public void the_user_validates_the_employee_data_was_edited_correctly_on_the_CafeTownsend_portal(String newfirstname,String newlastname,String newstardate,String newemail ) {

        Cafetownsend.WaitForElement(Cafetownsend.homePage().HomePageEmployeeList);
        Cafetownsend.homePage().ClickEmployeeOnHomePage(newfirstname + " " + newlastname);
        Cafetownsend.employees().ValidateInsertedEmployee(newfirstname,newlastname, newstardate,newemail);
        Cafetownsend.homePage().CafeLogout();
        Cafetownsend.WaitForElement(Cafetownsend.loginpage().SubmitButton);


    }


}
