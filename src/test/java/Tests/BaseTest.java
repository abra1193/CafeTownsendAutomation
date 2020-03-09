package Tests;

import Pages.PageGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    public WebDriver driver;
    PageGenerator cafetownsend;

    @BeforeClass
    public void initializeTest() {

        WebDriverManager.chromedriver().setup();
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


