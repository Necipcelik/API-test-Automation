package test;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;

public class C04_JsonObjesiOlusturma {
    @Test
    public void test03() {

        // Asagidaki JSON Objesini olusturup konsolda
        //yazdirin.
        //   {
        //"title":"Ahmet",
        //"body":"Merhaba",
        //"userId":1
        //   }

        JSONObject obj1 = new JSONObject();
        obj1.put("tittle", "Ahmet");
        obj1.put("body", "Merhaba");
        obj1.put("userID",1);
        System.out.println(obj1);
    }
}
