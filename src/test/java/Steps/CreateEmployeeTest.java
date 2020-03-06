package Steps;


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

        cafetownsend.loginpage().cafeLogIn(user, password);
    }

    @Test(priority = 2)
    @When("the user clicks on the Create button")
    public void the_user_clicks_on_the_Create_button() {

        cafetownsend.waitForElement(cafetownsend.homePage().create);
        cafetownsend.homePage().create.click();
    }


    @Parameters({"firstnameCreate", "lastnameCreate", "startdateCreate", "emailCreate"})
    @Test(priority = 3)
    @When("the user types the data to create the new employee")
    public void the_user_types_the_data_to_create_the_new_employee(String firstnameCreate, String lastnameCreate, String startdateCreate, String emailCreate) {

        cafetownsend.employees().addEmployee(firstnameCreate, lastnameCreate, startdateCreate, emailCreate);
    }

    @Parameters({"firstnameCreate", "lastnameCreate"})
    @Test(priority = 4)
    @Then("the new employee created is displayed on the employee list")
    public void the_new_employee_created_is_displayed_on_the_employee_list(String firstnameCreate, String lastnameCreate) {


        cafetownsend.homePage().selectEmployee(firstnameCreate + " " + lastnameCreate);
        cafetownsend.waitForElement(cafetownsend.homePage().edit);

    }

    @Parameters({"firstnameCreate", "lastnameCreate", "startdateCreate", "emailCreate"})
    @Test(priority = 5)
    @Then("the user validates the employee data was inserted correctly on the CafeTownsend portal")
    public void the_user_validates_the_employee_data_was_inserted_correctly_on_the_CafeTownsend_portal(String firstnameCreate, String lastnameCreate, String startdateCreate, String emailCreate)  {

        cafetownsend.homePage().edit.click();
        cafetownsend.employees().validateEmployeeInserted(firstnameCreate, lastnameCreate, startdateCreate, emailCreate);
        cafetownsend.waitForElement(cafetownsend.homePage().logoutButton);
        cafetownsend.homePage().cafeLogOut();

    }


}
