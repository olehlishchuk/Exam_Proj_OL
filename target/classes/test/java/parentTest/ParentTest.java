package parentTest;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class ParentTest {
    WebDriver webDriver;
    String browser = System.getProperty("browser");
    Logger logger = Logger.getLogger(getClass());
    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected EditHomePage editHomePage;
    protected MainPage mainPage;
    protected ProductPage productPage;
    protected ProfilePage profilePage;

    @Before
    public void setup() {
        if ("chrome".equals(browser) || browser == null) {
            File file = new File("./src/drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            webDriver = new ChromeDriver();
        } else {
            Assert.fail("Wrong browser name");
        }
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        mainPage = new MainPage(webDriver);
        }
        @After
    public void tearDown() {
        webDriver.quit();
        }

    public void checkExpectedResult(String message, boolean actualResult, boolean expectedResult) {
        Assert.assertEquals(message, expectedResult, actualResult);
    }

    public void checkExpectedResult (String message, boolean actualResult) {
        checkExpectedResult(message, actualResult, true);
    }
}
