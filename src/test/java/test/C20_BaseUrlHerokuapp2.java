package test;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C20_BaseUrlHerokuapp2 extends BaseUrlHerokuapp {

    @Test
    public void test20() {

        /*
        {
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2021-06-01",
"checkout" : "2021-06-10"
},
"additionalneeds" : "wi-fi"
}
         */

        specHerokuapp.pathParam("pp1", "booking");
        JSONObject requestBody = new JSONObject();
        JSONObject rezervasyonTarihleri = new JSONObject();

        rezervasyonTarihleri.put("checkin", "2021-06-01");
        rezervasyonTarihleri.put("checkout", "2021-06-10");

        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("additionalneeds", "wi-fi");

        Response response=given().contentType(ContentType.JSON)
                .when().spec(specHerokuapp)
                .body(requestBody.toString())
                .post("/{pp1}");

        response.then().assertThat()
                .statusCode(200)
                .body("booking.firstname", Matchers.equalTo("Ahmet"));
    }
}
