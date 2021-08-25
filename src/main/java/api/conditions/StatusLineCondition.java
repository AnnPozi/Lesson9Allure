package api.conditions;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import org.hamcrest.Matcher;

@AllArgsConstructor
public class StatusLineCondition implements Condition {

    private final String line;



    @Override
    public void check(ValidatableResponse response) {
        response.assertThat().statusLine(line);

    }

    @Override
    public String toString() {
        return "Json body filed \'" +
                line + "does not match";
    }
}
