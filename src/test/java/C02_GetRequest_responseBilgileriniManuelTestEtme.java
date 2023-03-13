import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_responseBilgileriniManuelTestEtme {
    @Test
    public void test01() {
        // https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        //gonderdigimizde donen Response’un,
        //status code’unun 200,
        //ve content type’inin application/json; charset=utf-8,
        //ve Server isimli Header’in degerinin Cowboy,
        //ve status Line’in HTTP/1.1 200 OK
        //ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
        String url = "https://restful-booker.herokuapp.com/booking/10";
        Response response = given().when().get(url);

        //   System.out.println(response.getBody().toString());

        System.out.println("status code " + response.getStatusCode());
        System.out.println("content code " + response.getContentType());
        System.out.println("server header degeri : " + response.getHeader("Server"));
        System.out.println("status line " + response.getStatusLine());
        System.out.println("responce süresi " + response.getTime());
    }
}
