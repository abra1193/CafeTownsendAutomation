package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CafeTownSend {

    WebDriver driver;
    WebDriverWait wait;

    public CafeTownSend(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);

    }

    public abstract void waitForElement(WebElement element);

    public abstract void write(WebElement element, String text);

    public abstract void assertEqualsTo(WebElement element, String text);

    public abstract String read(WebElement element);

    public abstract void click(WebElement element);


    public <TcafeTownSend extends BasePage> TcafeTownSend getInstance(Class<TcafeTownSend> cafeTownSendClass) {

        try {
            return PageFactory.initElements(driver,cafeTownSendClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}


/*

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
    }*/





