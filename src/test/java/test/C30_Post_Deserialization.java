package test;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestdataHerokuapp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C30_Post_Deserialization extends BaseUrlHerokuapp {
    @Test
    public void test30() {
        /*

https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
Response Body // expected data
{
"bookingid": 24,
"booking":
}
Request body
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

        Map<String,Object> requestBodyMap=TestdataHerokuapp.requestBodyMapOlustur();

        Map<String,Object> expectedData=TestdataHerokuapp.responceBodyMapOlustur();

        Response response=given().spec(specHerokuapp).contentType(ContentType.JSON)
                .when().body(requestBodyMap)
                .post("{pp1}");

        Map<String,Object> responceMap=response.as(HashMap.class);
     assertEquals(((Map)expectedData.get("booking")).get("firstname"),
                   ((Map)responceMap.get("booking")).get("firstname"));

        assertEquals(((Map)expectedData.get("booking")).get("lastname"),
                ((Map)responceMap.get("booking")).get("lastname"));

        assertEquals(((Map)expectedData.get("booking")).get("totalprice"),
                ((Map)responceMap.get("booking")).get("totalprice"));

        assertEquals(((Map)expectedData.get("booking")).get("depositpaid"),
                ((Map)responceMap.get("booking")).get("depositpaid"));

       // assertEquals(((Map)expectedData.get("booking")).get("additionalneeds"),
        //        ((Map)responceMap.get("booking")).get("fadditionalneeds"));

    }
}
