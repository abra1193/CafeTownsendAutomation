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

    @FindBy(how = How.XPATH, using = "//*[@id='login-form']/fieldset/label[1]/input")
    public WebElement username;

    @FindBy(how = How.XPATH, using = "//*[@id='login-form']/fieldset/label[2]/input")
    public WebElement password;

    @FindBy(how = How.XPATH, using = "//*[@id='login-form']/fieldset/button")
    public WebElement submitButton;

    @FindBy(how = How.XPATH,using = "//*[contains(text(),'Invalid username or password!')]")
    public WebElement invalidLoginMessage;

    public void cafeLogIn(String user,String pass) {
        waitForElement(submitButton);
        write(username, user);
        write(password, pass);
        submitButton.click();

    }

}


