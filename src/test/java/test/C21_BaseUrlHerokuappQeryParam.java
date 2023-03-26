package test;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C21_BaseUrlHerokuappQeryParam extends BaseUrlHerokuapp {
    @Test
    public void test21(){
 /*
    2- https://restful-booker.herokuapp.com/booking
endpointine yandaki body’ye sahip bir POST request
gonderdigimizde donen response’un status code’unun
200 oldugunu ve “firstname” degerinin “Ahmet”
oldugunu test edin
     */
    specHerokuapp.pathParam("pp1","booking")
            .queryParam("firstname","Susan");

        Response response=given()
                .when().spec(specHerokuapp)
                .get("/{pp1}");


        response.then().assertThat()
                .statusCode(200);

    }
}
