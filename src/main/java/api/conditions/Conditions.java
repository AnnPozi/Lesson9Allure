package api.conditions;

import org.hamcrest.Matcher;

public class Conditions {

    public static StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

    public static ResponseBodyCondition body(String path, Matcher matcher) {
        return new ResponseBodyCondition(path, matcher);
    }

    public static ContentTypeCondition header(String  path1, Matcher matcher) {
        return new ContentTypeCondition(path1, matcher);
    }

    public static StatusLineCondition statusLine(String line) {
        return new StatusLineCondition(line);
    }
}