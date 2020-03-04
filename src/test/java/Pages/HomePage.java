package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


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


    public void ClickOnTheHomePageEmployee(String name) {
        WaitForElement(HomePageEmployeeList);
        if (HomePageEmployeeList.getText().replaceAll("\n", "").contains(name)) {
            driver.findElement(By.xpath("//li[contains(text(),'" + name + "')]")).click();
        }
        WaitForElement(Edit);
        Click(Edit);
    }

    public void ValidatedDeletedEmployee(String name) {

        if (!HomePageEmployeeList.getText().replaceAll("\n", "").contains(name)
        ) {
            LogoutButton.click();
        }
    }


    public void CafeLogout() {

        Click(LogoutButton);


    }
}


      /*  WaitForElement(Create);

      //  List<WebElement> employeeList = HomePageEmployeeList;

        String EmployeeName = driver.findElement(By.xpath("//li[contains(text(),'" + name + "')]")).getText();

     //   String emplHomePageEmployeeList.getAttribute("value");

        for (WebElement element : employeeList)
            if(element.getText().contains(EmployeeName)) element.click();

        Optional<WebElement> found = empty();
        for (WebElement element : employeeList) {
            if (element.getText().contains(EmployeeName)) {
                found = Optional.of(element);
                break;
            }
        }
        found.get().click();

*/



