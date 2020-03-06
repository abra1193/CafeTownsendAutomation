package Base;

import Base.CafeTownSend;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BasePage extends CafeTownSend {


    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForElement(WebElement element) {

        wait.until(ExpectedConditions.visibilityOfAllElements(element));

    }

    @Override
    public void write(WebElement element, String text) {

        waitForElement(element);
        element.sendKeys(text);
    }

    @Override
    public void assertEqualsTo(WebElement element, String text) {

        waitForElement(element);
        Assert.assertEquals(read(element), text);

    }

    @Override
    public String read(WebElement element) {
        waitForElement(element);
        return element.getText();
    }

    @Override
    public void click(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


}
