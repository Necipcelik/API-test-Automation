package test;

import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummyExample;

import static io.restassured.RestAssured.given;

public class C26_Get_TestDataKullanimi extends BaseUrlDummyExample {
    @Test
    public void test26(){
        /*

http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde
donen response’un status code’unun 200, content Type’inin application/json ve body’sinin
asagidaki gibi oldugunu test edin.
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

        JSONObject exeptedData= TestDataDummyExample.jsonresponceBodyOlustur(3,"Ashton Cox",
                86000,66,"");

        Response response=given().spec(specDummyExample)
                .when().get("{pp1}/{pp2}");

        JsonPath responceJP=response.jsonPath();

        Assert.assertEquals(TestDataDummyExample.basariliSorguStatusCode,response.statusCode());
        Assert.assertEquals(TestDataDummyExample.contentType,response.contentType());

        Assert.assertEquals(exeptedData.getJSONObject("data").getString("profile_image"),
                responceJP.getString("data.profile_image"));
        Assert.assertEquals(exeptedData.getJSONObject("data").getInt("employee_salary"),
                responceJP.getInt("data.employee_salary"));

        Assert.assertEquals(exeptedData.getString("message"),responceJP.getString("message"));
        Assert.assertEquals(exeptedData.getString("status"),responceJP.getString("status"));





    }
}
