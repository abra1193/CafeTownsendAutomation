package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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

    public void AddEmployee(String Employeename, String EmployeeLastName, String EmployeeStartDate, String EmployeeEmail) {
        WaitForElement(Name);
        Write(Name, Employeename);
        Write(LastName, EmployeeLastName);
        Write(StartDate, EmployeeStartDate);
        Write(Email, EmployeeEmail);
        AddButton.click();


    }

    public void ValidateInsertedEmployee(String employeename, String employeeLastName, String employeeStartDate, String employeeEmail) {
        WaitForElement(Name);
        if (Name.getAttribute("value").contains(employeename)
                && LastName.getAttribute("value").contains(employeeLastName)
                && StartDate.getAttribute("value").contains(employeeStartDate)
                && Email.getAttribute("value").contains(employeeEmail))
            System.out.println("Employee: '" + employeename + " " + employeeLastName +"' was created correctly");
        BackButton.click();
    }


    public void EditEmployee(String Employeename, String EmployeeLastName, String EmployeeStartDate, String EmployeeEmail) {

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
