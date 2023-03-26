package test;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C22_BaseUrlHerokuappQeryParam extends BaseUrlHerokuapp {
    @Test
    public void test22() {

        specHerokuapp.pathParam("pp1", "booking")
                .queryParams("firstname", "Susan", "lastname", "Ericson");

        Response response=given()
                .when().spec(specHerokuapp)
                .get("/{pp1}");

        response.then().assertThat()
                .statusCode(200);

    }
}
