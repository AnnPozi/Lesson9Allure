package selenoidTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import dataProviders.RegistrationPageDataProvider;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTests {

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
        Selenide.open("http://automationpractice.com");
        mainPage.getProduct();
        mainPage.clickToProduct("Blouse");
    }

}
