package pagesSelenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SignInPage {
    public SelenideElement
            loginInput = $x("//a[@class='login']"),
            emailCreateInput = $x("//input[@id='email_create']");

    @Step("Click to SingIn page")
    public void clickToSingIn() {
        loginInput.click();
    }

    @Step("Input email {email}")
    public void inputEmailCreate(String email) {
        emailCreateInput.setValue(email);
    }


}
