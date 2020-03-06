package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager extends BasePage {

    public PageManager(WebDriver driver){

        super(driver);
    }

    public LoginPage loginpage() {
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public HomePage homePage() {
        return PageFactory.initElements(driver, HomePage.class);
    }

    public Employees employees() {
        return PageFactory.initElements(driver, Employees.class);

    }
}
