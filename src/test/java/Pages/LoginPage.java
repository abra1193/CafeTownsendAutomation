package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Parameters;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"login-form\"]/fieldset/label[1]/input")
    public WebElement username;
    @FindBy(how = How.XPATH, using = "//*[@id=\"login-form\"]/fieldset/label[2]/input")
    public WebElement password;
    @FindBy(how = How.XPATH, using = "//*[@id=\"login-form\"]/fieldset/button")
    public WebElement SubmitButton;

    public LoginPage CafeLogin() {
        WaitForElement(username);
        Write(username, "Luke");
        Write(password, "Skywalker");
        Click(SubmitButton);
        return this;
    }

}


