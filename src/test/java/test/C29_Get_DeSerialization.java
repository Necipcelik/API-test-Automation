package test;

import baseUrl.BaseUrlDummyExample;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummyExample;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C29_Get_DeSerialization extends BaseUrlDummyExample {
    @Test
    public void test29(){
/*

http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
gonderdigimizde donen response’un status code’unun 200, content Type’inin application/json
ve body’sinin asagidaki gibi oldugunu test edin.
Response Body
{
"status": "success",
"data": {
"id": 3,
"employee_name": "Ashton Cox",
"employee_salary": 86000,
"employee_age": 66,
"profile_image": ""
},
"message": "Successfully! Record has been fetched."
}
 */

        specDummyExample.pathParams("pp1","employee","pp2","3");

        Map<String,Object> expectedData= TestDataDummyExample.mapBodyOlustur();
     //   System.out.println(expectedData);

        Response response= given().spec(specDummyExample)
                .when()
                .get("{pp1}/{pp2}");

        Map<String,Object> responceMap=response.as(HashMap.class);

        Assert.assertEquals(TestDataDummyExample.basariliSorguStatusCode,response.statusCode());
        Assert.assertEquals(TestDataDummyExample.contentType,response.contentType());

        Assert.assertEquals(expectedData.get("message"),responceMap.get("message"));
        Assert.assertEquals(expectedData.get("status"),responceMap.get("status"));

        Assert.assertEquals(((Map)expectedData.get("data")).get("profile_image"),
                ((Map)responceMap.get("data")).get("profile_image"));

        Assert.assertEquals(((Map)expectedData.get("data")).get("employee_name"),
                ((Map)responceMap.get("data")).get("employee_name"));

        Assert.assertEquals(((Map)expectedData.get("data")).get("employee_salary"),
                ((Map)responceMap.get("data")).get("employee_salary"));
        Assert.assertEquals(((Map)expectedData.get("data")).get("id"),
                ((Map)responceMap.get("data")).get("id"));

        Assert.assertEquals(((Map)expectedData.get("data")).get("employee_age"),
                ((Map)responceMap.get("data")).get("employee_age"));
    }
}
