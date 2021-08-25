package apiTests;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import api.services.PeopleApiService;

public class BaseTest {

    public static PeopleApiService peopleApiService;

    @BeforeMethod
    @Step("Set up services")
    public void setUpServices() {
        RestAssured.baseURI = "https://swapi.dev/api/";
        peopleApiService = new PeopleApiService("/");
    }
}
