package selenoidTests;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class SelenoidWebDriverProvider implements WebDriverProvider {


    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setCapability("browserName", "chrome");
        browser.setCapability("browserVersion", "92.0");
        browser.setCapability("platform", "LINUX");
        browser.setCapability("enableVNC", true);
        browser.setCapability("enableLog", true);

        try {
            RemoteWebDriver driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    browser
            );
            driver.manage().window().setSize(new Dimension(1920, 1080));
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
