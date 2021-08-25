package pages;

import io.qameta.allure.Step;
import libs.WebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Exchange {

    WebDriver webDriver;
    Logger logger;
    WebElements webElements;



    public Exchange(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webElements = new WebElements(webDriver);
        PageFactory.initElements(webDriver, this);

    }


    /**
     * Method open url
     *
     */
    public void openExchangeUrl(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened " + url);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Page can't opened " + url);
            Assert.fail("Page can't opened " + url);
        }
    }

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]")
    public WebElement buyCurrency;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/select[1]/option[4]")
    public WebElement selectUAH;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
    public WebElement inputForAmount;

}
