package Base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 50);
        actions = new Actions(driver);
        actions.perform();

    }


    public void waitForElement(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void click(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void write(WebElement element, String text) {
        waitForElement(element);
        element.sendKeys(text);

    }

    public String read(WebElement element) {
        waitForElement(element);
        return element.getText();

    }

    public void assertAreEquals(WebElement element, String expected) {
        waitForElement(element);
        Assert.assertEquals(read(element), expected);
    }

    }



