package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateEmployeeTest extends BaseTest {
    @Given("the user login on the CafeTownsend portal")
    public void the_user_login_on_the_CafeTownsend_portal() {
        Cafetownsend.loginpage().CafeLogin();
    }


    @When("the user clicks on the Create button")
    public void the_user_clicks_on_the_Create_button() {

        Cafetownsend.homePage().Create.click();
    }


    @When("the user types the data to create the new employee")
    public void the_user_types_the_data_to_create_the_new_employee(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @Then("the new employee created is displayed on the employee list")
    public void the_new_employee_created_is_displayed_on_the_employee_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("the user validates the employee data was inserted correctly on the CafeTownsend portal")
    public void the_user_validates_the_employee_data_was_inserted_correctly_on_the_CafeTownsend_portal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
