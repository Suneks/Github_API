package tests.api.steps;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static tests.api.GitHubApiTests.BASE_URL;
import static tests.api.GitHubApiTests.TOKEN;

public class Spec {
    static RequestSpecification prepareRequest() {
        return given()
                .baseUri(BASE_URL)
                .auth()
                .oauth2(TOKEN)
                .contentType(JSON);
    }

    public static Response post(Object body, String url) {
        return prepareRequest()
                .body(body)
                .post(url);
    }
}
