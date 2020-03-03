package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {

        super(driver);
    }

    @FindBy(how = How.ID, using = "bAdd")
    public WebElement Create;

    @FindBy(how = How.ID, using = "bEdit")
    public WebElement Edit;

    @FindBy(how = How.ID, using = "bDelete")
    public WebElement Delete;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Logout')]")
    public WebElement LogoutButton;

    @FindBy(how = How.ID, using = "employee-list")
    public WebElement HomePageEmployeeList;

    public HomePage SelectEmployeeOnHomePage(String name) {
        WaitForElement(HomePageEmployeeList);
        if (
                HomePageEmployeeList.getText().replaceAll("\n", "").contains(name) == true) {
            driver.findElement(By.xpath("//li[contains(text(),'" + name + "')]")).click();
            WaitForElement(Edit);
            Click(Edit);
        } else {
            System.out.println("Employee doesn't exist on the Home Page Employee List");


        }
        return this;
    }

    public HomePage CafeLogout() {

        Click(LogoutButton);
        return this;

    }
}
