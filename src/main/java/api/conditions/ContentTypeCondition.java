package api.conditions;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import org.hamcrest.Matcher;

@AllArgsConstructor
public class ContentTypeCondition implements Condition{

    private final String path1;
    private final Matcher matcher;

    @Override
    public void check(ValidatableResponse response) {

        response.assertThat().header(path1, matcher);
    }

    @Override
    public String toString() {
        return "Json body filed \'" + path1 +
                "\' should match the condition: " + matcher;
    }
}
