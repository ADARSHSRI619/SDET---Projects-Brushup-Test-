package com.framework.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.filter.FilterableRequestSpecification;
import io.restassured.filter.FilterableResponseSpecification;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestResponseLoggingFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext context) {

        LOGGER.info("API Request -> {} {}", requestSpec.getMethod(), requestSpec.getURI());
        if (requestSpec.getBody() != null) {
            LOGGER.info("Request body -> {}", requestSpec.getBody());
        }

        Response response = context.next(requestSpec, responseSpec);

        LOGGER.info("API Response -> status: {}", response.getStatusCode());
        LOGGER.info("Response body -> {}", response.getBody().asPrettyString());
        return response;
    }
}
