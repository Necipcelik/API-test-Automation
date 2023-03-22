package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C11_Post_JsonPathIleBodyTesti {
    @Test
    public void test10() {
        /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
gonderdigimizde
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2023-01-10",
"checkout" : "2023-01-20"
},
"additionalneeds" : "wi-fi"
}
POST REQUEST, RESPONSE BODY BILGILERINI
ASSERT YAPARKEN JSONPATH KULLANMA
donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in,"Ahmet",
ve "lastname“in, "Bulut",
ve "totalprice“in,500,
ve "depositpaid“in,false,
ve "checkin" tarihinin 2023-01-10
ve "checkout" tarihinin 2023-01-20
ve "additionalneeds“in,"wi-fi"
oldugunu test edin
         */
        String url = " https://restful-booker.herokuapp.com/booking";
        JSONObject reqestBody = new JSONObject();
        JSONObject rezervasyonTarihleri = new JSONObject();
        rezervasyonTarihleri.put("checkin", "2023-01-10");
        rezervasyonTarihleri.put("checkout", "2023-01-20");

        reqestBody.put("firstname", "Ahmet");
        reqestBody.put("lastname", "Bulut");
        reqestBody.put("totalprice", 500);
        reqestBody.put("depositpaid", false);
        reqestBody.put("bookingdates", rezervasyonTarihleri);
        reqestBody.put("additionalneeds", "wi-fi");

        Response response = given().contentType(ContentType.JSON)
                           .when().body(reqestBody.toString())
                           .post(url);
        response.prettyPrint();

        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON).
                body("booking.firstname", equalTo("Ahmet"),"booking.lastname",equalTo("Bulut")
                        ,"booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2023-01-10"),
                        "booking.bookingdates.checkout",equalTo("2023-01-20"));


    }
}