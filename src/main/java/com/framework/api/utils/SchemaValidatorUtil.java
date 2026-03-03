package com.framework.api.utils;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public final class SchemaValidatorUtil {

    private SchemaValidatorUtil() {
    }

    public static void validateSchema(Response response, String schemaFileName) {
        response.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + schemaFileName));
    }
}
