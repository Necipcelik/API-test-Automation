package test;

import baseUrl.BaseUrlJsonplaceholderApi;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_BaseUrlDummyRestapi extends BaseUrlJsonplaceholderApi {
    @Test
    public void test18(){
        /*
         3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
          gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
        null oldugunu test edin
         */
     specJsonPlaceholder.pathParams("pp1","posts","pp2",50);
        Response response=given()
                .when().spec(specJsonPlaceholder)
                .delete("/{pp1}/{pp2}");

        response.then().assertThat()
                .statusCode(200)
                .body("title", Matchers.nullValue());

    }
}
