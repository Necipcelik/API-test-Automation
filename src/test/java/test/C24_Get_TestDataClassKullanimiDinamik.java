package test;

import baseUrl.BaseUrlJsonplaceholderApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestData_JsonPlaceholder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_Get_TestDataClassKullanimiDinamik extends BaseUrlJsonplaceholderApi {
    @Test
    public void test24() {

        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda donen
response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
ediniz
Response body :
{
"userId": 4,
"id": 40,
"title": "enim quo cumque",
"body": "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia
quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
}
         */

        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", "40");

        JSONObject expectedData = TestData_JsonPlaceholder.JsonBodyOlustur(4, 40, "enim quo cumque", "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam");
        Response response=given().spec(specJsonPlaceholder)
                .when()
                .get("{pp1}/{pp2}");

        JsonPath responceJsonPath=response.jsonPath();

     assertEquals(TestData_JsonPlaceholder.basariliSorguStatusCodu,response.statusCode());
     assertEquals(expectedData.getInt("userId"),responceJsonPath.getInt("userId"));
     assertEquals(expectedData.getInt("id"),responceJsonPath.getInt("id"));
     assertEquals(expectedData.getString("title"),responceJsonPath.getString("title"));
     assertEquals(expectedData.getString("body"),responceJsonPath.getString("body"));
    }
}
