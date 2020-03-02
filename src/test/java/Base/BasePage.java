package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 35);
    }

    public void WaitForElement(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void Click(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void Write(WebElement element, String text) {
        WaitForElement(element);
        element.sendKeys(text);

    }

    public String Read(WebElement element) {
        WaitForElement(element);
        return element.getText();

    }

    public void Assert(WebElement element, String expected) {
        WaitForElement(element);
        Assert.assertEquals(Read(element), expected);
    }



}
