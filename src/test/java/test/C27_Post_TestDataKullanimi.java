package test;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestdataHerokuapp;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Post_TestDataKullanimi extends BaseUrlHerokuapp {
    @Test
    public void test27(){
        /*
        C27_Post_TestDataKullanimi
https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.

"additionalneeds": "wi-fi"
} }

         */

        specHerokuapp.pathParam("pp1","booking");

        JSONObject requestBody= TestdataHerokuapp.JsonRequestBodyOlustur();

        JSONObject expectedData=TestdataHerokuapp.JsonResponceBodyOlustur();


        Response response=given().spec(specHerokuapp).contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post("{pp1}");
     //   response.prettyPrint();

        JsonPath responceJP=response.jsonPath();

       assertEquals(expectedData.getJSONObject("booking").getString("firstname"),
                responceJP.getString("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").getString("lastname"),
                responceJP.getString("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").getInt("totalprice"),
                responceJP.getInt("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").getBoolean("depositpaid"),
                responceJP.getBoolean("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").getString("additionalneeds"),
                responceJP.getString("booking.additionalneeds"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin"),
                responceJP.getString("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout"),
                responceJP.getString("booking.bookingdates.checkout"));
    }
    }

