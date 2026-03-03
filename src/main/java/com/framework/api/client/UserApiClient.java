package com.framework.api.client;

import io.restassured.response.Response;

import java.util.Map;

public class UserApiClient extends BaseApiClient {

    public Response getUser(int id) {
        return get("/users/" + id);
    }

    public Response createUser(Map<String, Object> payload) {
        return post("/users", payload);
    }

    public Response updateUser(int id, Map<String, Object> payload) {
        return put("/users/" + id, payload);
    }

    public Response deleteUser(int id) {
        return delete("/users/" + id);
    }
}
