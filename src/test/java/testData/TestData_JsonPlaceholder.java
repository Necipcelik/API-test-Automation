package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestData_JsonPlaceholder {

    public static int basariliSorguStatusCodu = 200;
    public static String contentType = "application/json; charset=utf-8";
    public static String headerConnection = "keep-alive";

    public static JSONObject responceBodyOLustur22() {

        JSONObject expectedData = new JSONObject();

        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear um mollitia molestiae aut atque rem suscipit\nnam impedit esse");


        return expectedData;


    }

    public static JSONObject JsonBodyOlustur(int userId, int id, String title, String body) {

        JSONObject expectedData = new JSONObject();

        expectedData.put("userId", userId);
        expectedData.put("id", id);
        expectedData.put("title", title);
        expectedData.put("body", body);


        return expectedData;


    }

    /*
    "title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
     */
    public static Map<String, Object> bodyOluturMap() {

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("title", "Ahmet");
        bodyMap.put("body", "Merhaba");
        bodyMap.put("userId", 10);
        bodyMap.put("id", 70);

        return bodyMap;


    }
}
