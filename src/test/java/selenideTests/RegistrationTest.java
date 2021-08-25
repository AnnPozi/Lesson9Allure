package selenideTests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import dataProviders.RegistrationPageDataProvider;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenShooter.class, TextReport.class})
@Report
public class RegistrationTest extends BaseTest{

    @Test(dataProvider = "registrationNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void testCreateNewAccount(Account userAccount) {
        signInPage.clickToSingIn();
        signInPage.inputEmailCreate(faker.internet().emailAddress());
        registrationPage.submitButtonCreate();
        registrationPage.registrationUser(userAccount);
        registrationPage.submitAccount();
        myAccountPage.titleRegisteredAccount.shouldHave(Condition.visible);
        Assert.assertEquals(myAccountPage.getAccountName(),
                userAccount.getFirstCustomerName() + " " + userAccount.getLastCustomerName());
    }

    @Test
    public void testFindProduct() {
        Selenide.open(Configuration.baseUrl);
        mainPage.getProduct();
        mainPage.clickToProduct("Blouse");
        mainPage.clickToAddToCart("Add to cart");
        mainPage.clickToProceed("Proceed to checkout");
        mainPage.clickToProceed2(".button.btn.btn-default.standard-checkout.button-medium");
        mainPage.clickToProceed3("button[name='processAddress'] span");
        mainPage.clickToAgree("#cgv");
        mainPage.clickToProceed3("button[name='processCarrier'] span");
        mainPage.clickPayment("a[title='Pay by check.']");
        mainPage.clickConfirmation("button[class='button btn btn-default button-medium'] span");
        mainPage.checkCompletion(".alert.alert-success");
    }

    public void testNegative(){


    }
}
