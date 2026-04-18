package utils;

import io.restassured.response.Response;

public class APIUtils {

    public static int getStatusCode(Response response) {
        return response.getStatusCode();
    }

    public static String getBody(Response response) {
        return response.getBody().asString();
    }
}