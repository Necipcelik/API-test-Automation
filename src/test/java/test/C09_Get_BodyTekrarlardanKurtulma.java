package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_BodyTekrarlardanKurtulma {
    @Test
    public void test08(){
        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
        donen Response’un,
          status code’unun 200,
            ve content type’inin application-json,
           ve response body’sindeki
               "firstname“in, "Susan",
           ve "lastname“in, "Jackson",
           ve "totalprice“in, 612,
                ve "depositpaid“in, false,
           ve "additionalneeds“in, "Breakfast"
               oldugunu test edin
         */
        String url="https://restful-booker.herokuapp.com/booking/10";
        Response response=given().when().get(url);


        /* response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Susan"))
                .body("lastname", Matchers.lessThan(1000))
                .body("depositpaid", Matchers.equalTo(true))
                .body("additionalneeds", Matchers.notNullValue());
          */
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Eric"),"Lastname",
                        equalTo(null),"totalprice",lessThan(1000),
                        "depositpaid",equalTo(false),"additionalneeds",notNullValue()
                        );
    }
}
