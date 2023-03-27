package testData;

import org.json.JSONObject;

public class TestDataDummyExample {

    public static int basariliSorguStatusCode = 200;
    public static String contentType = "application/json";


    /*
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
    public static JSONObject jsonresponceBodyOlustur(int id, String employee_name, int employee_salary,
                                                     int employee_age, String profil_image) {

        JSONObject responceBody = new JSONObject();
        JSONObject dataBody = new JSONObject();

        dataBody.put("id", id);
        dataBody.put("employee_name", employee_name);
        dataBody.put("employee_salary", employee_salary);
        dataBody.put("employee_age", employee_age);
        dataBody.put("profile_image", profil_image);

        responceBody.put("status", "success");
        responceBody.put("data", dataBody);
        responceBody.put("message", "Successfully! Record has been fetched.");


        return responceBody;


    }

}
