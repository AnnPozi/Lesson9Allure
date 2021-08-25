package api.services;

import api.assertions.AssertableResponse;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

public class PeopleApiService {

    private Logger logger = Logger.getLogger(getClass());

    RequestSpecification requestSpec;
    public final String defaultContentType = "application/json";

    public PeopleApiService(String basePath) {
        this.requestSpec = RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(defaultContentType)
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .basePath(basePath);
    }

    @Step("Get people")
    public api.assertions.AssertableResponse getPeople() {
        return new AssertableResponse(
                requestSpec.when()
                        .get("/people/1")
                        .then());
    }
}

