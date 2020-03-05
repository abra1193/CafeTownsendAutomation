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
    public WebElement Name;

    @FindBy(how = How.XPATH, using = "//label[2]/input[@type='text']")
    public WebElement LastName;

    @FindBy(how = How.XPATH, using = "//label[3]/input[@type='text']")
    public WebElement StartDate;

    @FindBy(how = How.XPATH, using = "//label[4]/input[@type='email']")
    public WebElement Email;

    @FindBy(how = How.XPATH, using = "//div/ul[2]/li/a[@class='subButton bCancel']")
    public WebElement CancelButton;

    @FindBy(how = How.XPATH, using = "//div/button[2]")
    public WebElement AddButton;

    @FindBy(how = How.XPATH, using = "//li/a[@class='subButton bBack']")
    public WebElement BackButton;

    @FindBy(how = How.XPATH, using = "//div/button[@type='submit']")
    public WebElement UpdateButton;

    @FindBy(how = How.XPATH, using = "//div/p[contains(text(),'Delete')]")
    public WebElement DeleteButton;

    @FindBy(how = How.XPATH, using = "//form[@name='employeeForm']/fieldset/label")
    public WebElement EmployeeForm;

    public void AddEmployee(String Employeename, String EmployeeLastName, String EmployeeStartDate, String EmployeeEmail) {
        WaitForElement(Name);
        Write(Name, Employeename);
        Write(LastName, EmployeeLastName);
        Write(StartDate, EmployeeStartDate);
        Write(Email, EmployeeEmail);
        AddButton.click();


    }

    public void ValidateInsertedEmployee(String employeename, String employeeLastName, String employeeStartDate, String employeeEmail) {
        WaitForElement(EmployeeForm);
        List<WebElement> employeeformfields = EmployeeForm.findElements(By.tagName("input"));
        for (WebElement label : employeeformfields)
            if (label.getAttribute("value").equals((employeename)) || label.getAttribute("value").equals((employeeLastName))
                    || label.getAttribute("value").equals((employeeStartDate)) || label.getAttribute("value").equals((employeeStartDate))) {
                System.out.println("Employee" + " " + employeename +""+ employeeLastName + " " + "was created correctly");
                WaitForElement(EmployeeForm);
                Click(BackButton);
            } else {
                System.out.println("Employee" + " " + employeename +" "+ employeeLastName + " " + "was not created correctly");
            }

    }

    public void EditEmployee(String Employeename, String EmployeeLastName, String EmployeeStartDate, String EmployeeEmail) {
        WaitForElement(Name);
        Name.clear();
        Write(Name, Employeename);
        LastName.clear();
        Write(LastName, EmployeeLastName);
        StartDate.clear();
        Write(StartDate, EmployeeStartDate);
        Email.clear();
        Write(Email, EmployeeEmail);
        UpdateButton.click();

    }


}
