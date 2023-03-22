package test;

import baseUrl.BaseUrlJsonplaceholderApi;
import io.restassured.config.MatcherConfig;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlDummyRestapi extends BaseUrlJsonplaceholderApi {
    /*
    Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
        1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde
     donen response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test
        edin
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde
      donen response’un status code’unun 200 oldugunu ve “title” degerinin
        “optio dolor molestias sit” oldugunu test edin

     */
    @Test
    public void test16() {
        specJsonPlaceholder.pathParam("pp1", "posts");
        Response response = given()
                .when().spec(specJsonPlaceholder)
                .get("/{pp1}");
        response.then().assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));


    }

    @Test
    public void test17() {
        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", 44);
     Response response=given()
             .when().spec(specJsonPlaceholder)
             .get("/{pp1}/{pp2}");

     response.then().assertThat()
             .statusCode(200);


    }
}
