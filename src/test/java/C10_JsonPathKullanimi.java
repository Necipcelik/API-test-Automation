import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {
    @Test
    public void method1(){
        JSONObject kisiBilgileriJsonObj=new JSONObject();
        JSONObject adresJsonObj=new JSONObject();
        JSONArray telefonBilgileriArray=new JSONArray();
        JSONObject cepTelefonuJsonObj=new JSONObject();
        JSONObject evTelefonuJsonObj=new JSONObject();

      adresJsonObj.put("streetAddress","naist street");
      adresJsonObj.put("city","Nara");
      adresJsonObj.put("postalCode","630-0192");
      cepTelefonuJsonObj.put("type","iphone");
      cepTelefonuJsonObj.put("number","0123-4567-8888");
     evTelefonuJsonObj.put("type","home");
     evTelefonuJsonObj.put("number","0123-4567-8910");
     telefonBilgileriArray.put(cepTelefonuJsonObj);
     telefonBilgileriArray.put(evTelefonuJsonObj);
     kisiBilgileriJsonObj.put("firtsName","John");
     kisiBilgileriJsonObj.put("lastName","doe");
     kisiBilgileriJsonObj.put("age",26);
     kisiBilgileriJsonObj.put("adress",adresJsonObj);
     kisiBilgileriJsonObj.put("phoneNumbers",telefonBilgileriArray);
        System.out.println(kisiBilgileriJsonObj);
        System.out.println("first name : "+kisiBilgileriJsonObj.get("firtsName"));
        System.out.println("last name : "+kisiBilgileriJsonObj.get("lastName"));
        System.out.println("cadde "+kisiBilgileriJsonObj.getJSONObject("adress").get("streetAddress"));
        System.out.println(kisiBilgileriJsonObj.getJSONObject("adress").get("city"));
        System.out.println("cep tel no : "+kisiBilgileriJsonObj.getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("number"));

    }
}
