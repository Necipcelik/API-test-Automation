package test;

import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Data;
import pojos.PojoDummyExampleResponce;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C33_Get_Pojo extends BaseUrlDummyExample {
    @Test
    public void test33() {
        /*
        C33_Get_Pojo
http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
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

        specDummyExample.pathParams("pp1", "employee", "pp2", "3");

        Data dataPojo = new Data(3, "Ashton Cox", 86000, 66, "");

        PojoDummyExampleResponce exeptedResponceBody =
                new PojoDummyExampleResponce("status", dataPojo, "Successfully! Record has been fetched.");

        Response response = given().spec(specDummyExample)
                .when()
                .get("{pp1}/{pp2}");
        //  response.prettyPrint();

        JsonPath responceJP = response.jsonPath();

        assertEquals(exeptedResponceBody.getMessage(), responceJP.getString("message"));
        // assertEquals(exeptedResponceBody.getStatus(), responceJP.getString("success"));
        assertEquals(exeptedResponceBody.getData().getId(),
                responceJP.get("data.id"));
        assertEquals(exeptedResponceBody.getData().getEmployeeName(),
                responceJP.get("data.employee_name"));
        assertEquals(exeptedResponceBody.getData().getEmployeeAge(),
                responceJP.get("data.employee_age"));
        assertEquals(exeptedResponceBody.getData().getEmployeeSalary(),
                responceJP.get("data.employee_salary"));
        assertEquals(exeptedResponceBody.getData().getProfileImage(),
                responceJP.get("data.profile_image"));

    }
}
