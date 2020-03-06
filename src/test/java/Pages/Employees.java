package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class Employees extends BasePage {

    public Employees(WebDriver driver) {

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

    public void validateEmployeeInserted(String employeename, String employeeLastName, String employeeStartDate, String employeeEmail) {
        waitForElement(employeeForm);
        List<WebElement> employeeformfields = employeeForm.findElements(By.tagName("input"));
        for (WebElement label : employeeformfields)
            if (label.getAttribute("value").equals((employeename)) || label.getAttribute("value").equals((employeeLastName))
                    || label.getAttribute("value").equals((employeeStartDate)) || label.getAttribute("value").equals((employeeStartDate)) || label.getAttribute("value").equals((employeeEmail))) {
                System.out.printf("Employee %s %s data was inserted correctly%n", employeename, employeeLastName);
                waitForElement(employeeForm);
                click(backButton);
            } else
                System.out.printf("Employee %s %s data was not inserted correctly%n", employeename, employeeLastName);

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

