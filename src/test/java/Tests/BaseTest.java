package Tests;

import Base.BasePage;
import Base.CafeTownSend;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    WebDriver driver;
    public CafeTownSend cafetownsend;

    @BeforeClass
    public void initializeTest() {

        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        cafetownsend = new BasePage(driver);
        driver.navigate().to("http://cafetownsend-angular-rails.herokuapp.com/");
    }

    @AfterClass
    public void teardownTest() {

        driver.quit();
    }


}


