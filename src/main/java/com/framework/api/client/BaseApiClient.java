package com.framework.api.client;

import com.framework.api.builder.RequestSpecBuilderFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseApiClient {
    protected RequestSpecification requestSpec() {
        return RequestSpecBuilderFactory.defaultSpec();
    }

    protected Response get(String path) {
        return requestSpec()
                .when()
                .get(path)
                .then()
                .extract()
                .response();
    }

    protected Response post(String path, Object payload) {
        return requestSpec()
                .body(payload)
                .when()
                .post(path)
                .then()
                .extract()
                .response();
    }

    protected Response put(String path, Object payload) {
        return requestSpec()
                .body(payload)
                .when()
                .put(path)
                .then()
                .extract()
                .response();
    }

    protected Response delete(String path) {
        return requestSpec()
                .when()
                .delete(path)
                .then()
                .extract()
                .response();
    }
}
