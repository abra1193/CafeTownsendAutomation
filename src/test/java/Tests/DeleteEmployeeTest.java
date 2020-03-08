package Tests;

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

        cafetownsend.loginpage().cafeLogIn(user, password);
    }

    @Parameters({"firstnameDelete", "lastnameDelete", "startdateDelete", "emailDelete"})
    @Test(priority = 2)
    @When("the user selects an employee from the employee list")
    public void the_user_selects_an_employee_from_the_employee_list(String firstnameDelete, String lastnameDelete, String startdateDelete, String emailDelete) {

        cafetownsend.waitForElement(cafetownsend.homePage().create);
        cafetownsend.homePage().create.click();
        cafetownsend.employees().addEmployee(firstnameDelete, lastnameDelete, startdateDelete, emailDelete);
        cafetownsend.homePage().selectEmployee(String.format("%s %s", firstnameDelete, lastnameDelete));
        cafetownsend.homePage().edit.click();

    }

    @Test(priority = 3)
    @And("the user clicks on the Delete button")
    public void theUserClicksOnTheDeleteButton() {

        cafetownsend.waitForElement(cafetownsend.employees().name);
        cafetownsend.employees().deleteButton.click();
    }

    @Parameters({"firstnameDelete", "lastnameDelete"})
    @Test(priority = 4)
    @Then("the user validates the employee was deleted correctly from the CafeTownsend portal employee list")
    public void theUserValidatesTheEmployeeWasDeletedCorrectlyFromTheCafeTownsendPortalEmployeeList(String firstnameDelete, String lastnameDelete) {

        driver.switchTo().alert().accept();
        cafetownsend.waitForElement(cafetownsend.homePage().employeeList);
        cafetownsend.homePage().validateDeletedEmployee(String.format("%s %s", firstnameDelete, lastnameDelete));
        cafetownsend.homePage().cafeLogOut();
        cafetownsend.waitForElement(cafetownsend.loginpage().submitButton);
    }
}



