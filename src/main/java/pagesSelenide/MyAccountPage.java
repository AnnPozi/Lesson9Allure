package pagesSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MyAccountPage {
    public SelenideElement
            accountBtn = $("#header > div.nav > div >div > nav > div:nth-child(1) > a"),
            titleRegisteredAccount = $x("//div[@id='center_column']/h1");

    @Step("Get account name")
    public String getAccountName() {
        return accountBtn.getText();
    }

    @Step("Get header name {text}")
    public void getHeaderName(String text) {
        titleRegisteredAccount.shouldHave(Condition.visible);
    }
}
