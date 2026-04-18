package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

    public RequestSpecification request() {
        return RestAssured
                .given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON);
    }
}