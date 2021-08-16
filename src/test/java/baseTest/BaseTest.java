package baseTest;

import com.github.javafaker.Faker;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import libs.CustomListener;
import libs.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.MyAccountPage;
import pages.RegistrationPage;
import pages.SingInPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

@Listeners({CustomListener.class})
public class BaseTest {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    public Faker faker;
    public Utils utils = new Utils();
    private String patchToScreenShot;

    public RegistrationPage registrationPage;
    public SingInPage singInPage;
    public MyAccountPage myAccountPage;

    public BaseTest() {
    }

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    @Step("Set up browser options {browser}")
    public void setUp(@Optional("chrome") String browser) {
        if (browser.toLowerCase().equals("chrome")) {
            File chrome = new File("/Users/apozina/IdeaProjects/lesson9/drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
            webDriver = new ChromeDriver();
        } else if (browser.toLowerCase().equals("firefox")) {
            File firefox = new File("/Users/apozina/IdeaProjects/lesson9/drivers/geckodriver");
            System.setProperty("webdriver.gecko.driver", firefox.getAbsolutePath());
            webDriver = new FirefoxDriver();
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file = new File("");
        patchToScreenShot = file.getAbsolutePath() + "\\resources\\screenshot" +
                this.getClass().getPackage().getName() + "\\" +
                this.getClass().getSimpleName() + ".png";

        registrationPage = new RegistrationPage(webDriver);
        singInPage = new SingInPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        faker = new Faker();

        try {
            webDriver.get("http://automationpractice.com");
            logger.info("Open url - http://automationpractice.com");
        } catch (Exception e) {
            logger.error("Can't open url");
            Assert.fail("Can't open url");
        }
    }

    @Step("Tear down browser")
    @AfterClass
    public void tearDown() {
        if (!(webDriver == null)) {
            screenshot();
            utils.screenShot(patchToScreenShot, webDriver);
            webDriver.quit();
        }
    }

    public void checkAC(boolean actual, boolean expected) {
        Assert.assertEquals(actual, expected);
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }
}
