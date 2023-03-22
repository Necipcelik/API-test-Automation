package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_Get_ResponsedegerleriniOtotmasyonIleTestEtme {
    @Test
    public void test02(){
        // https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        //gonderdigimizde donen Response’un,
        //status code’unun 200,
        //ve content type’inin application/json; charset=utf-8,
        //ve Server isimli Header’in degerinin Cowboy,
        //ve status Line’in HTTP/1.1 200 OK
        // test ediniz
        String url = "https://restful-booker.herokuapp.com/booking/10";
       Response responce =given().when().get(url);

       responce.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8").
               header("Server","Cowboy").statusLine("HTTP/1.1 200 OK");



    }
}
