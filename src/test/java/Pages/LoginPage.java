package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"login-form\"]/fieldset/label[1]/input")
    public WebElement Username;

    @FindBy(how = How.XPATH, using = "//*[@id=\"login-form\"]/fieldset/label[2]/input")
    public WebElement Password;

    @FindBy(how = How.XPATH, using = "//*[@id=\"login-form\"]/fieldset/button")
    public WebElement SubmitButton;

    public void CafeLogin(String user,String password) {
        WaitForElement(SubmitButton);
        Write(Username, user);
        Write(Password, password);
        SubmitButton.click();

    }

}


