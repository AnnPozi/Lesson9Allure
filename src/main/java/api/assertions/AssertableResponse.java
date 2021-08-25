package api.assertions;


import api.conditions.Condition;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssertableResponse {

    public final ValidatableResponse response;

    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }
}