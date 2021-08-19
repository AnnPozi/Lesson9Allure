package pagesSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.Account;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    public SelenideElement
            submitButtonCreate = $x("//button[@id='SubmitCreate']"),
            fromAccount = $x("//form[@id='account-creation_form']/div[@class='account_creation']/div[1]/div[1]"),
           // genderMr = $(By.id("id_gender1")),
            //genderMrs = $(By.id("id_gender2")),
            customerFNInput = $(By.id("customer_firstname")),
            customerLNInput = $(By.id("customer_lastname")),
            emailInput = $(By.id("email")),
            passwordInput = $x("//input[@type='password']"),
            dayDropDown = $(By.id("days")),
            monthsDropDown = $(By.id("months")),
            yearsDropDown = $(By.id("years")),
            checkboxNewsLetter = $(By.id("uniform-newsletter")),
            checkboxNewsOptin = $(By.id("optin")),
            firstNameInput = $x("//input[@id='firstname']"),
            LastNameInput = $x("//input[@id='lastname']"),
            companyName = $(By.id("company")),
            addressByDefault = $x("//div[@class='account_creation']//p[4]//input[@type='text']"),
            addressLine = $x("//div[@class='account_creation']//p[5]//input[@type='text']"),
            cityInput = $x("//input[@id='city']"),
            selectStateByIndex = $(By.id("id_state")),
            postCodeInput = $x("//input[@id='postcode']"),
            idCountry = $(By.id("id_country")),
            phoneMobileInput = $(By.id("phone_mobile")),
            aliasInput = $(By.id("alias")),
            submitAccount = $(By.id("submitAccount"));

    @Step("Submit button create")
    public void submitButtonCreate() {
        submitButtonCreate.click();
    }

    @Step("Input from account")
    public void inputFromAccount() {
        fromAccount.click();
    }

//    @Step("Select gender {gender}")
//    public void selectGender(String gender) {
//        if (gender.equals("1")) {
//            genderMr.selectRadio(gender);
//        } else {
//            genderMrs.selectRadio(gender);
//        }
//    }

    @Step("Input customer first name {firstName}")
    public void inputCustomerFirstName(String firstName) {
        customerFNInput.setValue(firstName);
    }

    @Step("Input customer last name {lastName}")
    public void inputCustomerLastName(String lastName) {
        customerLNInput.setValue(lastName);
    }

    @Step("Input email {email}")
    public void inputEmail(String email) {
        emailInput.setValue(email);
    }

    @Step("Input password {password}")
    public void inputPassword(String password) {
        passwordInput.setValue(password);
    }

    @Step("Select birthday {day}")
    public void selectBirthDay(String day) {
        dayDropDown.selectOptionByValue(day);
    }

    @Step("Select birthday month {month}")
    public void selectBirthMonth(String month) {
        monthsDropDown.selectOptionByValue(month);
    }

    @Step("Select birth year {year}")
    private void selectBirthYear(String year) {
        yearsDropDown.selectOptionByValue(year);
    }

    @Step("Click checkbox news")
    public void clickCheckBoxNews() {
        checkboxNewsLetter.click();
    }

    @Step("Click checkbox news optin")
    public void clickCheckBoxNewsOptin() {
        checkboxNewsOptin.click();
    }

    @Step("Input first name {firstName}")
    public void inputFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    @Step("Input last name {lastName}")
    public void inputLastName(String lastName) {
        LastNameInput.setValue(lastName);
    }

    @Step("Input company {company}")
    public void inputCompany(String company) {
        companyName.setValue(company);
    }

    @Step("Input address by default {address}")
    public void inputAddressByDefault(String address) {
        addressByDefault.setValue(address);
    }

    @Step("Input address line {address}")
    public void inputAddressLine(String address) {
        addressLine.setValue(address);
    }

    @Step("Input city {city}")
    public void inputCity(String city) {
        cityInput.setValue(city);
    }

    @Step("Select city {state}")
    public void selectCity(String state) {
        selectStateByIndex.selectOptionContainingText(state);
    }

    @Step("Input post code {postCode}")
    public void inputPostCode(String postCode) {
        postCodeInput.setValue(postCode);
    }

    @Step("Is displayed text by xpath {text}")
    public void isDisplayedTextByXpath(String text) {
        $(By.xpath(text)).shouldHave(Condition.visible);
    }

    @Step("Select country {text}")
    public void selectCountry(String text) {
        idCountry.selectOptionContainingText(text);
    }

    @Step("Input mobile {mobile}")
    public void inputMobile(String mobile) {
        phoneMobileInput.setValue(mobile);
    }

    @Step("Input alias {alias}")
    public void inputAlias(String alias) {
        aliasInput.setValue(alias);
    }

    @Step("Submit account")
    public void submitAccount() {
        submitAccount.click();
    }

    public void registrationUser(Account account) {
       // selectGender(account.getGender());
        inputCustomerFirstName(account.getFirstCustomerName());
        inputCustomerLastName(account.getLastCustomerName());
        inputEmail(account.getEmail());
        inputPassword(account.getPass());
        selectBirthDay(account.getDay());
        selectBirthMonth(account.getMonth());
        selectBirthYear(account.getYear());
        inputFirstName(account.getFirstName());
        inputLastName(account.getLastName());
        inputCompany(account.getCompany());
        inputAddressByDefault(account.getAddress1());
        inputAddressLine(account.getAddress2());
        inputCity(account.getCity());
        selectCity(account.getState());
        inputPostCode(account.getPostcode());
        selectCountry(account.getCountry());
        inputMobile(account.getPhone_mobile());
        inputAlias(account.getAlias());
    }
}
