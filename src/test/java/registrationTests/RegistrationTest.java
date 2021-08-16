package registrationTests;

import baseTest.BaseTest;
import dataProviders.RegistrationPageDataProvider;
import io.qameta.allure.*;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    private final String FIRST_NAME = "Anna";
    private final String LAST_NAME = "Pozina";
    //Update NUllPointer
//    private final String EMAIL = faker.internet().emailAddress();
    private final String PASSWORD = "qwerty123";
    private final String STREET = "street New York, 12";
    private final String CITY = "New York";
    private final String CITY_INDEX = "New York";
    private final String POST_CODE = "12345";
    private final String COUNTRY = "United States";
    private final String PHONE_MOBILE = "1234567890";

//    @Test
//    public void testRegistration() {
//        //Your personal info
//        singInPage.clickToSingIn();
//        singInPage.inputEmailCreate(faker.internet().emailAddress());
//
//        registrationPage.submitButtonCreate();
//        registrationPage.inputFromAccount();
//        //another method
//        registrationPage.inputCustomerFN(FIRST_NAME);
//        registrationPage.inputCustomerLN(LAST_NAME);
//        registrationPage.inputEmail(faker.internet().emailAddress());
//        registrationPage.inputPassword(PASSWORD);
//        //your address
//        registrationPage.inputFirstName(FIRST_NAME);
//        registrationPage.inputLastName(LAST_NAME);
//        registrationPage.inputAddressByDefault(STREET);
//        registrationPage.inputCity(CITY);
//        registrationPage.selectCity(CITY_INDEX);
//        registrationPage.inputPostCode(POST_CODE);
//        registrationPage.selectCountry(COUNTRY);
//        registrationPage.inputMobilePhone(PHONE_MOBILE);
//        registrationPage.inputAlias(faker.internet().emailAddress());
//        registrationPage.clickSubmitAccount();
//        myAccountPage.getHeaderName("My account");
//        checkAC(myAccountPage.titleRegisteredAccount.isDisplayed(), true);
//    }

    @Epic(value = "Registration")
    @Story(value = "User can registration for this test")
    @Description(value = "Test registration new user")
    @Issue("https://jira.com/345345_234")
    @TmsLink(value = "TL-623")
    @Link(value = "link", url = "https://github.com/allure-framework")
    @Owner(value = "Anna")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(dataProvider = "registrationNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void testCreateNewAccount(Account userAccount) {
        singInPage.clickToSingIn();
        singInPage.inputEmailCreate(faker.internet().emailAddress());
        registrationPage.submitButtonCreate();
        registrationPage.registrationUser(userAccount);
        registrationPage.clickSubmitAccount();
        checkAC(myAccountPage.titleRegisteredAccount.isDisplayed(), true);
        Assert.assertEquals(myAccountPage.getAccountName(),
                userAccount.getFirstCustomerName() + " " + userAccount.getLastCustomerName());
    }
}
