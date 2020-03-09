package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 50);


    }

    public void waitForElement(WebElement element) {


        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void click(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public void write(WebElement element, String text) {
        waitForElement(element);
        element.sendKeys(text);

    }


}







