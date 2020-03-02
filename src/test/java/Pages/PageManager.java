package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager extends BasePage {

    public PageManager(WebDriver driver){

        super(driver);
    }
    public LoginPage loginpage(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        return loginPage;


    }
}
