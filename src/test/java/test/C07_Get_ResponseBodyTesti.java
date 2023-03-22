package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_Get_ResponseBodyTesti {
    @Test
    public void test06() {
       /*
       https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
    donen Response’in
      status code'unun 200,
       ve content type'inin Aplication.JSON,
         ve response body'sinde bulunan userId'nin 5,
      ve response body'sinde bulunan title'in "optio dolor molestias sit"
          oldugunu test edin.
        */

        String url="https://jsonplaceholder.typicode.com/posts/44";

       // JSONObject responceBody=new JSONObject();

        Response response=given().when().get(url);
        response.then().assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("userId",Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));

    }
}
