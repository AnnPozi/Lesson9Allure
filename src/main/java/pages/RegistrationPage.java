package pages;

import io.qameta.allure.Step;
import model.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends MainPage {

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name = "SubmitCreate")
    public WebElement submitButtonCreate;

    @FindBy(xpath = "//form[@id='account-creation_form']/div[@class='account_creation']/div[1]/div[1]")
    public WebElement fromAccount;

    @FindBy(id = "id_gender1")
    public WebElement genderMr;

    @FindBy(id = "id_gender2")
    public WebElement genderMrs;

    @FindBy(id = "customer_firstname")
    public WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    public WebElement customerLastName;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(id = "days")
    public WebElement daysDropDown;

    @FindBy(id = "months")
    public WebElement monthsDropDown;

    @FindBy(id = "years")
    public WebElement yearsDropDown;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement LastNameInput;

    @FindBy(id = "company")
    public WebElement companyName;

    @FindBy(xpath = "//div[@class='account_creation']//p[4]//input[@type='text']")
    public WebElement addressByDefault;

    @FindBy(xpath = "//div[@class='account_creation']//p[5]//input[@type='text']")
    public WebElement addressLine;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityInput;

    @FindBy(id = "id_state")
    public WebElement selectState;

    @FindBy(css = "#postcode")
    public WebElement postCodeInput;

    @FindBy(id = "id_country")
    public WebElement idCountry;

    @FindBy(id = "phone_mobile")
    public WebElement phoneMobileInput;

    @FindBy(id = "alias")
    public WebElement aliasInput;

    @FindBy(xpath = "//button[@name='submitAccount']")
    public WebElement submitAccount;

    /**
     * Method open SingIn page
     */
    public void openRegistrationPage() {
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    /**
     * Method submit button
     */
    @Step("Submit button create")
    public void submitButtonCreate() {
        webElements.clickOnElement(submitButtonCreate);
    }

    @Step("Input from account")
    public void inputFromAccount() {
        webElements.clickOnElement(fromAccount);
    }

    @Step("Select gender {gender}")
    public void selectGender(String gender) {
        if (gender.equals("Mr.")) {
            webElements.clickRadioButton(genderMr, gender);
        } else {
            webElements.clickRadioButton(genderMrs, gender);
        }
    }

    @Step("Input customer first name {firstName}")
    public void inputCustomerFN(String firstName) {
        webElements.inputText(customerFirstName, firstName);
    }

    @Step("Input customer last name {lastName}")
    public void inputCustomerLN(String lastName) {
        webElements.inputText(customerLastName, lastName);
    }

    @Step("Input email {email}")
    public void inputEmail(String email) {
        webElements.inputText(emailInput, email);
    }

    @Step("Input password {password}")
    public void inputPassword(String password) {
        webElements.inputText(passwordInput, password);
    }

    @Step("Select birthday {day}")
    public void selectBirthDay(String day) {
        webElements.selectValueInDropDown(daysDropDown, day);
    }

    @Step("Select birthday month {month}")
    public void selectBirthMonth(String month) {
        webElements.selectValueInDropDown(monthsDropDown, month);
    }

    @Step("Select birth year {year}")
    public void selectBirthYear(String year) {
        webElements.selectValueInDropDown(yearsDropDown, year);
    }

    @Step("Input first name {firstName}")
    public void inputFirstName(String firstName) {
        webElements.inputText(firstNameInput, firstName);
    }

    @Step("Input last name {lastName}")
    public void inputLastName(String lastName) {
        webElements.inputText(LastNameInput, lastName);
    }

    @Step("Input company {company}")
    public void inputCompany(String company) {
        webElements.inputText(companyName, company);
    }

    @Step("Input address by default {address}")
    public void inputAddressByDefault(String address) {
        webElements.inputText(addressByDefault, address);
    }

    @Step("Input address line {address}")
    public void inputAddressLine(String address) {
        webElements.inputText(addressLine, address);
    }

    @Step("Input city {city}")
    public void inputCity(String city) {
        webElements.inputText(cityInput, city);
    }

    @Step("Input post code {postCode}")
    public void inputPostCode(String postCode) {
        webElements.inputText(postCodeInput, postCode);
    }

    @Step("Input mobile {mobile}")
    public void inputMobilePhone(String phone) {
        webElements.inputText(phoneMobileInput, phone);
    }

    @Step("Input alias {alias}")
    public void inputAlias(String alias) {
        webElements.inputText(aliasInput, alias);
    }

    @Step("Submit account")
    public void clickSubmitAccount() {
        webElements.clickOnElement(submitAccount);
    }

    @Step("Select city {text}")
    public void selectCity(String text) {
        webElements.selectTextInDropDownByText(selectState, text);
    }

    @Step("Select country {text}")
    public void selectCountry(String text) {
        webElements.selectTextInDropDownByText(idCountry, text);
    }

    public void registrationUser(Account account) {
        selectGender(account.getGender());
        inputCustomerFN(account.getFirstCustomerName());
        inputCustomerLN(account.getLastCustomerName());
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
        inputMobilePhone(account.getPhone_mobile());
        inputAlias(account.getAlias());
    }
}
