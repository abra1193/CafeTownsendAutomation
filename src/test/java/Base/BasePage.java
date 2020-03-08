package Base;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public ExtentReports extentReports;
    public static ExtentTest scenarioDef;
    public static ExtentTest feautures;
    public static String reportLocation = "Users/AbrahamE/Report";

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

    public String read(WebElement element) {
        waitForElement(element);
        return element.getText();

    }



}



