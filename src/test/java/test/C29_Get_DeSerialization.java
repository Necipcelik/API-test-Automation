package test;

import baseUrl.BaseUrlDummyExample;
import org.junit.Test;

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











    }
}
