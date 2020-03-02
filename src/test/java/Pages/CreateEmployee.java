package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateEmployee extends BasePage {

    public CreateEmployee(WebDriver driver) {

        super(driver);
    }

    @FindBy(how = How.XPATH, using = "")
    public WebElement Name;

    @FindBy(how = How.XPATH, using = "")
    public WebElement LastName;

    @FindBy(how = How.XPATH, using = "")
    public WebElement StartDate;

    @FindBy(how = How.XPATH, using = "")
    public WebElement Email;

    @FindBy(how = How.XPATH, using = "//div/ul[2]/li/a[@class='subButton bCancel']")
    public WebElement CancelButton;


    public CreateEmployee CreateEmployee(String Employeename, String EmployeeLastName, String EmployeeStartDate, String EmployeeEmail) {

        Write(Name, Employeename);
        Write(LastName, EmployeeLastName);
        Write(StartDate, EmployeeStartDate);
        Write(Email, EmployeeEmail);
        return this;
    }

}
