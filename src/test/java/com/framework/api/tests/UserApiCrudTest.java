package com.framework.api.tests;

import com.framework.api.base.BaseApiTest;
import com.framework.api.client.UserApiClient;
import com.framework.api.utils.ResponseValidator;
import com.framework.api.utils.SchemaValidatorUtil;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Epic("REST API Automation")
@Feature("Users API CRUD")
public class UserApiCrudTest extends BaseApiTest {
    private final UserApiClient userApiClient = new UserApiClient();

    @Test(description = "Validate GET user endpoint")
    @Story("Get existing user details")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldGetUserById() {
        Response response = userApiClient.getUser(2);

        ResponseValidator.validateStatusCode(response, 200);
        ResponseValidator.validateJsonField(response, "data.id", "2");
        ResponseValidator.validateJsonFieldNotNull(response, "data.email");
        SchemaValidatorUtil.validateSchema(response, "get-user-schema.json");
    }

    @Test(description = "Validate POST user endpoint")
    @Story("Create a user")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldCreateUser() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", "morpheus");
        payload.put("job", "leader");

        Response response = userApiClient.createUser(payload);

        ResponseValidator.validateStatusCode(response, 201);
        ResponseValidator.validateJsonField(response, "name", "morpheus");
        ResponseValidator.validateJsonField(response, "job", "leader");
        ResponseValidator.validateJsonFieldNotNull(response, "id");
        ResponseValidator.validateJsonFieldNotNull(response, "createdAt");
    }

    @Test(description = "Validate PUT user endpoint")
    @Story("Update existing user")
    @Severity(SeverityLevel.NORMAL)
    public void shouldUpdateUser() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", "morpheus");
        payload.put("job", "zion resident");

        Response response = userApiClient.updateUser(2, payload);

        ResponseValidator.validateStatusCode(response, 200);
        ResponseValidator.validateJsonField(response, "name", "morpheus");
        ResponseValidator.validateJsonField(response, "job", "zion resident");
        ResponseValidator.validateJsonFieldNotNull(response, "updatedAt");
    }

    @Test(description = "Validate DELETE user endpoint")
    @Story("Delete existing user")
    @Severity(SeverityLevel.NORMAL)
    public void shouldDeleteUser() {
        Response response = userApiClient.deleteUser(2);
        ResponseValidator.validateStatusCode(response, 204);
    }
}
