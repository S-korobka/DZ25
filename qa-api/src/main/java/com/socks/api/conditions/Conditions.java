package com.socks.api.conditions;

import lombok.experimental.UtilityClass;
import org.hamcrest.Matcher;

@UtilityClass
public class Conditions {

    public StatusCode statusCode(int code) {
        return new StatusCode(code);
    }

    public BodyCondition bodyField(String jsonPath,Matcher<String> matcher) {

        return new BodyCondition(jsonPath, matcher);
    }
}
