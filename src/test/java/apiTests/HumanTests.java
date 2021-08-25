package apiTests;


import api.assertions.AssertableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static api.conditions.Conditions.*;
import static org.hamcrest.core.Is.is;

public class HumanTests extends BaseTest{

    @Test
    void testGetUserName() {
        peopleApiService
                .getPeople()
                .shouldHave(statusCode(200))
                .shouldHave(body("name", is("Luke Skywalker")));

    }
    @Test
    void testGetType() {
        peopleApiService
                .getPeople()
                .shouldHave(header("Content-Type", is("application/json")))
                .shouldHave(statusLine("HTTP/1.1 200 OK"));
    }

    @Test
    void testGetUserLuke() {
        AssertableResponse r = peopleApiService.getPeople();
        Assert.assertEquals(200, r.response.extract().statusCode());
        Assert.assertEquals("application/json", r.response.extract().contentType());
        System.out.println(r.response.extract().body().jsonPath());

    }
}
