package Tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EditEmployeeTest extends BaseTest {


    @Parameters({"user", "password"})
    @Test(priority = 1)
    @Given("the user login on the CafeTownsend portal")
    public void the_user_login_on_the_CafeTownsend_portal(String user, String password) {

        cafetownsend.loginpage().cafeLogIn(user, password);
    }

    @Parameters({"firstnameEdit", "lastnameEdit", "startdateEdit", "emailEdit"})
    @Test(priority = 2)
    @When("the user selects an employee from the employee list")
    public void the_user_selects_an_employee_from_the_employee_list(String firstnameEdit, String lastnameEdit, String startdateEdit, String emailEdit) {

        cafetownsend.waitForElement(cafetownsend.homePage().create);
        cafetownsend.homePage().create.click();
        cafetownsend.employees().addEmployee(firstnameEdit, lastnameEdit, startdateEdit, emailEdit);
        cafetownsend.homePage().selectEmployee(String.format("%s %s", firstnameEdit, lastnameEdit));
    }

    @Test(priority = 3)
    @And("the user clicks on the Edit button")
    public void the_user_clicks_on_the_Edit_button() {

        cafetownsend.waitForElement(cafetownsend.homePage().edit);
        cafetownsend.homePage().edit.click();
        cafetownsend.waitForElement(cafetownsend.employees().employeeForm);

    }

    @Parameters({"newfirstname", "newlastname", "newstartdate", "newemail"})
    @Test(priority = 4)
    @When("the user edits an employee")
    public void the_user_edits_an_employee(String newfirstname, String newlastname, String newstardate, String newemail) {

        cafetownsend.employees().editEmployee(newfirstname, newlastname, newstardate, newemail);
        cafetownsend.homePage().selectEmployee(String.format("%s %s", newfirstname, newlastname));

    }

    @Parameters({"newfirstname", "newlastname", "newstartdate", "newemail"})
    @Test(priority = 5)
    @Then("the user validates the employee data was edited correctly on the CafeTownsend portal")
    public void the_user_validates_the_employee_data_was_edited_correctly_on_the_CafeTownsend_portal(String newfirstname, String newlastname, String newstardate, String newemail) {

        cafetownsend.homePage().edit.click();
        Assert.assertEquals(cafetownsend.employees().name.getAttribute("value"),newfirstname);
        Assert.assertEquals(cafetownsend.employees().lastName.getAttribute("value"),newlastname);
        Assert.assertEquals(cafetownsend.employees().startDate.getAttribute("value"),newstardate);
        Assert.assertEquals(cafetownsend.employees().email.getAttribute("value"),newemail);
        cafetownsend.homePage().cafeLogOut();
        cafetownsend.waitForElement(cafetownsend.loginpage().submitButton);


    }


}
