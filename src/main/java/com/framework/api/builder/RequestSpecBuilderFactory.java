package com.framework.api.builder;

import com.framework.api.filters.RequestResponseLoggingFilter;
import com.framework.config.ConfigReader;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestSpecBuilderFactory {

    private RequestSpecBuilderFactory() {
    }

    public static RequestSpecification defaultSpec() {
        RestAssuredConfig config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", ConfigReader.getInt("connect.timeout.ms"))
                        .setParam("http.socket.timeout", ConfigReader.getInt("read.timeout.ms")));

        return new RequestSpecBuilder()
                .setConfig(config)
                .setBaseUri(ConfigReader.get("api.base.url"))
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .addFilter(new RequestResponseLoggingFilter())
                .addFilter(new AllureRestAssured())
                .build();
    }
}
