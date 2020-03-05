package Steps;

import Pages.PageManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    PageManager Cafetownsend;

    @BeforeClass
    public void InitializeTest() {

        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Cafetownsend = new PageManager(driver);
        wait = new WebDriverWait(driver, 50);
        driver.navigate().to("http://cafetownsend-angular-rails.herokuapp.com/");
    }

    @AfterClass
    public void TeardownTest() {

        driver.quit();
    }


}


