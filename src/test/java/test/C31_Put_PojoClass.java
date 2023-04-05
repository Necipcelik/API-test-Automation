package test;

import baseUrl.BaseUrlJsonplaceholderApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoJsonPlaceholder;
import testData.TestData_JsonPlaceholder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C31_Put_PojoClass extends BaseUrlJsonplaceholderApi {

    /*

https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
request yolladigimizda donen response’in response body’sinin asagida verilen ile ayni
oldugunu test ediniz
POJO CLASS ILE EXPECTED DATA TESTI
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
    @Test
    public void test31() {
        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", "70");

        PojoJsonPlaceholder requestBodyPojo=new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);

        PojoJsonPlaceholder expectedDataPojo=new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);

        Response response=given().spec(specJsonPlaceholder).contentType(ContentType.JSON)
                .when().body(requestBodyPojo)
                .put("{pp1}/{pp2}");
       PojoJsonPlaceholder responcePojo=response.as(PojoJsonPlaceholder.class);

        assertEquals(TestData_JsonPlaceholder.basariliSorguStatusCodu,response.statusCode());
        assertEquals(TestData_JsonPlaceholder.contentType,response.contentType());
        assertEquals(TestData_JsonPlaceholder.headerConnection,response.header("Connection"));

        assertEquals(expectedDataPojo.getTitle(),responcePojo.getTitle());
        assertEquals(expectedDataPojo.getBody(),responcePojo.getBody());
        assertEquals(expectedDataPojo.getUserId(),responcePojo.getUserId());
        assertEquals(expectedDataPojo.getId(),responcePojo.getId());
    }
}
