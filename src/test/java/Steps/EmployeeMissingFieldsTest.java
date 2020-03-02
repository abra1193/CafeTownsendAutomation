package Steps;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class EmployeeMissingFieldsTest extends  BaseTest {

    @Given("the user login on the CafeTownsend portal for second time")
    public void the_user_login_on_the_CafeTownsend_portal_for_second_time() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user clicks on the Create button for second time")
    public void the_user_clicks_on_the_Create_button_for_second_time() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user types the data to create the new employee for second time")
    public void the_user_types_the_data_to_create_the_new_employee_for_second_time(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @But("the portal displays a missing field warning")
    public void the_portal_displays_a_missing_field_warning() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
