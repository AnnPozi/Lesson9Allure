package dataProviders;

import com.github.javafaker.Faker;
import model.AccountBuilder;
import org.testng.annotations.DataProvider;

public class RegistrationPageDataProvider {

    public Faker faker = new Faker();

    @DataProvider
    public Object[][] registrationNewUser() {
        return new Object[][]{
                {
                        new AccountBuilder()
                                .withGender("Mr.")
                                .withFirstCustomerName("Anna")
                                .withLastCustomerName("Pozina")
                                .withEmail(faker.internet().emailAddress())
                                .withPassword("qwerty312")
                                .withBirthdayDay("22")
                                .withBirthdayMonth("11")
                                .withBirthdayYear("1989")
                                .withFirstName("Anna")
                                .withLastName("Pozina")
                                .withCompany("NNN")
                                .withAddress1("street New York, 12")
                                .withAddress2("street New York, 14")
                                .withCity("New York")
                                .withState("New York")
                                .withPostalCode("12345")
                                .withCountry("United States")
                                .withPhoneMobile("1111111111")
                                .withAliasAddress("Anna's home")
                                .build()
                }
        };
    }
}
