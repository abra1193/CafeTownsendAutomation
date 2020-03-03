package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

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

    @FindBy(how = How.ID, using = "employee-list")
    public WebElement HomePageEmployeeList;


    public void SelectEmployeeOnHomePage(String name) {
        WaitForElement(HomePageEmployeeList);
        List<WebElement> employeeList = driver.findElements(By.id("employee-list"));
      //  employeeList.stream().forEach(webElement -> {if(webElement.getText().equalsIgnoreCase(name
   //     ))} );
    //    employeeList.stream().filter(webElement -> webElement.getText().equals(name)).findFirst().get().click();

/*
        if (

                HomePageEmployeeList.getText().replaceAll("\n", "").contains(name)) {
            WaitForElement(driver.findElement(By.xpath("//li[contains(text(),'" + name + "')]")));
            driver.findElement(By.xpath("//li[contains(text(),'" + name + "')]")).click();
            WaitForElement(Edit);
            Click(Edit);
        } else {
            System.out.println("Employee doesn't exist on the Home Page Employee List");
*/


    }

    public HomePage CafeLogout() {

        Click(LogoutButton);
        return this;

    }
}
