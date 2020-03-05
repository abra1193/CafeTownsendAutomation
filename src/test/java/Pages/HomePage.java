package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


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

    @FindBy(how = How.XPATH, using = "//*[@id='employee-list-container']/ul[@id='employee-list']")
    public WebElement HomePageEmployeeList;


    public void ClickEmployeeOnHomePage(String name) {
        WaitForElement(HomePageEmployeeList);
        List<WebElement> employee = HomePageEmployeeList.findElements(By.tagName("li"));
        for (WebElement li : employee) {
            if (li.getText().equals(name))
                actions.moveToElement(li).doubleClick().perform();
        }
    }

    public void ValidatedDeletedEmployee(String name) {
        WaitForElement(HomePageEmployeeList);
        List<WebElement> employee = HomePageEmployeeList.findElements(By.tagName("li"));
        for (WebElement li : employee) {
            if (!li.getText().equals(name))
                System.out.println("Employee: " + name + "  was deleted correctly");
        }

    }

    public void CafeLogout() {

        Click(LogoutButton);


    }
}




