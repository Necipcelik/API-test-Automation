package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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

    public static JSONObject JsonResponceBodyOlustur() {
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

        JSONObject responceBody = new JSONObject();
        JSONObject bookingBody = JsonRequestBodyOlustur();

        responceBody.put("bookingid", 24);
        responceBody.put("booking", bookingBody);


        return responceBody;


    }
    /*
     {
"firstname": "Ahmet",
"lastname": "Bulut",
"totalprice": 500,
"depositpaid": false,
"bookingdates": {
"checkin": "2021-06-01",
"checkout": "2021-06-10"
},
"additionalneeds": "wi-fi"
}
     */

    public static Map<String, Object> requestBodyMapOlustur() {

        Map<String, Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("firstname", "Ahmet");
        requestBodyMap.put("lastname", "Bulut");
        requestBodyMap.put("totalprice", 500.0);
        requestBodyMap.put("depositpaid", false);
        requestBodyMap.put("bookingdates", mapBookingdates());
        requestBodyMap.put("additionalneeds", "wi-fi");
        return requestBodyMap;

    }

    public static Map<String, String> mapBookingdates() {

        Map<String, String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin", "2021-06-01");
        bookingdatesMap.put("checkout", "2021-06-10");
        return bookingdatesMap;


    }

    public static Map<String,Object> responceBodyMapOlustur(){

        Map<String,Object> responceBodyMap=new HashMap<>();
        responceBodyMap.put("bookingid",24.0);
        responceBodyMap.put("booking",requestBodyMapOlustur());
        return responceBodyMap;



    }

}
