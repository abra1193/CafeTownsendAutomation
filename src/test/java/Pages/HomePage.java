package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {

        super(driver);
    }

    @FindBy(how = How.ID, using = "bAdd")
    public WebElement create;

    @FindBy(how = How.ID, using = "bEdit")
    public WebElement edit;

    @FindBy(how = How.ID, using = "bDelete")
    public WebElement delete;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Logout')]")
    public WebElement logoutButton;

    @FindBy(how = How.XPATH, using = "//*[@id='employee-list-container']/ul[@id='employee-list']")
    public WebElement homePageEmployeeList;


    public void selectEmployee(String name) {
        waitForElement(homePageEmployeeList);
        click(homePageEmployeeList);
        List<WebElement> employee = homePageEmployeeList.findElements(By.tagName("li"));
        for (WebElement li : employee)
            if (li.getText().equals(name))
                click(li);
        waitForElement(homePageEmployeeList);
    }

    public void ValidateEmployeeDeleted(String name) {
        List<WebElement> employee = homePageEmployeeList.findElements(By.tagName("li"));
        for (WebElement li : employee) {
            if (!li.getText().equals(name))
                waitForElement(homePageEmployeeList);
        }

    }

    public void cafeLogOut() {

        click(logoutButton);


    }
}




