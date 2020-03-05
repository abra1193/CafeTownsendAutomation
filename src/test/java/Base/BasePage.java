package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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


    public void WaitForElement(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
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
/*
    public boolean RetryClick(WebElement element) {
        boolean result = false;
        int attemps = 0;
        while (attemps < 2) {
            try {
                element.click();
                result = true;
                break;

            } catch (StaleElementReferenceException e) {

            }

            attemps++;
        }
        return result;*/
    }



