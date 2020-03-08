package Tests;

import Pages.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected WebDriver driver;
    PageGenerator cafetownsend;
    protected WebDriverWait wait;

    @BeforeClass
    public void initializeTest() {

        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        cafetownsend = new PageGenerator(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("http://cafetownsend-angular-rails.herokuapp.com/");
    }

    @AfterClass
    public void teardownTest() {

        driver.quit();
    }


}


