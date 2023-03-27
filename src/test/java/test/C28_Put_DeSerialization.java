package test;

import baseUrl.BaseUrlJsonplaceholderApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestData_JsonPlaceholder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Put_DeSerialization extends BaseUrlJsonplaceholderApi {
    @Test
    public void test28() {
        /*

https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
request yolladigimizda donen response’in response body’sinin asagida verilen ile ayni
oldugunu test ediniz
DE-SERIALIZATION ILE EXPECTED DATA TESTI
Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
         */
        Response response;
        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", 70);

        Map<String, Object> requestBodyMap = TestData_JsonPlaceholder.bodyOluturMap();

        Map<String, Object> expectedData = TestData_JsonPlaceholder.bodyOluturMap();

        response = given().spec(specJsonPlaceholder).contentType(ContentType.JSON)
                .when().body(requestBodyMap)
                .put("{pp1}/{pp2}");
        //  response.prettyPrint();

        Map<String,Object>  responceMap=response.as(HashMap.class);

        assertEquals(expectedData.get("title"),responceMap.get("title"));
        assertEquals(expectedData.get("body"),responceMap.get("body"));
        assertEquals(expectedData.get("id"),responceMap.get("id"));
        assertEquals(expectedData.get("userId"),responceMap.get("userId"));

    }
}
