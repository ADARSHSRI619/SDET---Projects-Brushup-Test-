package com.framework.api.utils;

import io.restassured.response.Response;
import org.testng.Assert;

public final class ResponseValidator {

    private ResponseValidator() {
    }

    public static void validateStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode,
                "Unexpected response status code");
    }

    public static void validateJsonField(Response response, String jsonPath, String expectedValue) {
        Assert.assertEquals(response.jsonPath().getString(jsonPath), expectedValue,
                "Unexpected value for JSON field: " + jsonPath);
    }

    public static void validateJsonFieldNotNull(Response response, String jsonPath) {
        Assert.assertNotNull(response.jsonPath().get(jsonPath),
                "Expected non-null value for JSON field: " + jsonPath);
    }
}
