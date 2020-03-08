package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class EmployeesPage extends BasePage {

    public EmployeesPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//label[1]/input[@type='text']")
    public WebElement name;

    @FindBy(how = How.XPATH, using = "//label[2]/input[@type='text']")
    public WebElement lastName;

    @FindBy(how = How.XPATH, using = "//label[3]/input[@type='text']")
    public WebElement startDate;

    @FindBy(how = How.XPATH, using = "//label[4]/input[@type='email']")
    public WebElement email;

    @FindBy(how = How.XPATH, using = "//div/ul[2]/li/a[@class='subButton bCancel']")
    public WebElement cancelButton;

    @FindBy(how = How.XPATH, using = "//div/button[2]")
    public WebElement addButton;

    @FindBy(how = How.XPATH, using = "//li/a[@class='subButton bBack']")
    public WebElement backButton;

    @FindBy(how = How.XPATH, using = "//div/button[@type='submit']")
    public WebElement updateButton;

    @FindBy(how = How.XPATH, using = "//div/p[contains(text(),'Delete')]")
    public WebElement deleteButton;

    @FindBy(how = How.XPATH, using = "//form[@name='employeeForm']/fieldset/label")
    public WebElement employeeForm;

    public void addEmployee(String employeename, String employeeLastName, String employeeStartDate, String employeeEmail) {
        waitForElement(name);
        write(name,
                employeename);
        write(lastName,
                employeeLastName);
        write(startDate,
                employeeStartDate);
        write(email,
                employeeEmail);
        addButton.click();
    }

    public void editEmployee(String employeeName, String employeeLastName, String employeeStartDate, String employeeEmail) {

        waitForElement(name);
        name.clear();
        write(name,
                employeeName);
        lastName.clear();
        write(lastName,
                employeeLastName);
        startDate.clear();
        write(startDate,
                employeeStartDate);
        email.clear();
        write(email,
                employeeEmail);
        updateButton.click();

    }


}

