package currencyExchange;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.Exchange;

public class ExchangeText {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    public Exchange exchange;

    @Test
    public void exchangeMoneyTest() {
        exchange.openExchangeUrl("https://finance.i.ua/converter/");
        exchange.buyCurrency.click();
        exchange.selectUAH.click();
        exchange.inputForAmount.sendKeys("4000");





    }
}
