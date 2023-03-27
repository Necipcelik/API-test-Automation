package test;

import baseUrl.BaseUrlJsonplaceholderApi;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestData_JsonPlaceholder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonplaceholderApi {
    @Test
    public void test25() {

        /*

https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request
yolladigimizda donen response’in
status kodunun 200, content type’inin “application/json; charset=utf-8”, Connection header
degerinin “keep-alive”
ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

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

        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", 70);
        JSONObject requestBody= TestData_JsonPlaceholder
                .JsonBodyOlustur(10,70,"Ahmet","Merhaba");

        JSONObject expectedDaTa=TestData_JsonPlaceholder
                .JsonBodyOlustur(10,70,"Ahmet","Merhaba");

        Response response=given().spec(specJsonPlaceholder)
                .when().body(requestBody.toString()).contentType(ContentType.JSON)
                .put("{pp1}/{pp2}");

        /*
        status kodunun 200, content type’inin “application/json; charset=utf-8”, Connection header
degerinin “keep-alive”
ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         */
         JsonPath responseJsonPath=response.jsonPath();

       assertEquals(TestData_JsonPlaceholder.basariliSorguStatusCodu,response.statusCode());
       assertEquals(TestData_JsonPlaceholder.contentType,response.contentType());
       assertEquals(TestData_JsonPlaceholder.headerConnection,response.header("Connection"));

       assertEquals(expectedDaTa.getInt("id"),responseJsonPath.getInt("id"));
        assertEquals(expectedDaTa.getInt("userId"),responseJsonPath.getInt("userId"));
        assertEquals(expectedDaTa.getString("title"),responseJsonPath.getString("title"));
        assertEquals(expectedDaTa.getString("body"),responseJsonPath.getString("body"));





    }
}
