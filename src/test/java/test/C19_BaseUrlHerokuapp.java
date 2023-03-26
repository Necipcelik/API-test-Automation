package test;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerokuapp extends BaseUrlHerokuapp {
    /*
    Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin
1- https://restful-booker.herokuapp.com/booking endpointine bir GET request gonderdigimizde
donen response’un status code’unun 200 oldugunu ve Response’ta 12 booking oldugunu test
edin


     */
    @Test
    public void test19(){

specHerokuapp.pathParam("pp1","booking");

        Response response=given()
                .when().spec(specHerokuapp)
                .get("/{pp1}");

        JsonPath responceJsonPath=response.jsonPath();
        System.out.println(responceJsonPath.getList("bookingid").size());

        response.then().assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(6236));


    }
}
