package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Parameters;

public class CreateEmployee extends BasePage {

    public CreateEmployee(WebDriver driver) {

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

    public CreateEmployee AddEmployee(String Employeename, String EmployeeLastName, String EmployeeStartDate, String EmployeeEmail) {

        Write(Name, Employeename);
        Write(LastName, EmployeeLastName);
        Write(StartDate, EmployeeStartDate);
        Write(Email, EmployeeEmail);
        Click(AddButton);
        return this;
    }

    public CreateEmployee ValidateInsertedEmployeeData(String Employeename, String EmployeeLastName, String EmployeeStartDate, String EmployeeEmail) {

        if (Name.getAttribute("value").contains(Employeename)  && LastName.getAttribute("value").contains(EmployeeLastName )&& StartDate.getAttribute("value").contains(EmployeeStartDate) && Email.getAttribute("value").contains(EmployeeEmail)) {
            System.out.println("The Employee data was saved correctly after it was created from the Create Employee Screen");
        } else {

            System.out.println("The Employee data was not saved correctly after it was created on the Create Employee Screen");

        }

/*
        Assert(Name, Employeename);
        LastName.getAttribute("value");
        Assert(LastName, Employeename);
        StartDate.getAttribute("value");
        Assert(StartDate, EmployeeStartDate);
        Email.getAttribute("value");
        Assert(Email, Employeename);
*/
        return this;

    }
}
