package testData;

import org.json.JSONObject;

public class TestdataHerokuapp {
    /*
    Response Body

{
"firstname": "Ahmet",
"lastname": "Bulut",
"totalprice": 500,
"depositpaid": false,
"bookingdates": {
"checkin": "2021-06-01",
"checkout": "2021-06-10"
}
     */
    public static JSONObject JsonRequestBodyOlustur() {

        JSONObject requestBody = new JSONObject();
        JSONObject bookingDataBody = new JSONObject();

        bookingDataBody.put("checkin", "2021-06-01");
        bookingDataBody.put("checkout", "2021-06-10");

        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates", bookingDataBody);
        requestBody.put("additionalneeds", "wi-fi");


        return requestBody;


    }
    public static JSONObject JsonResponceBodyOlustur(){
        /*
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

     JSONObject responceBody=new JSONObject();
     JSONObject bookingBody=JsonRequestBodyOlustur();

     responceBody.put("bookingid",24);
     responceBody.put("booking",bookingBody);






        return responceBody;




    }

}
