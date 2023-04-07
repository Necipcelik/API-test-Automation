package test;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoHerokuappBookingdates;
import pojos.PojoHerokuappRequestBody;
import pojos.PojoHerokuappResponce;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C32_Post_Pojo extends BaseUrlHerokuapp {
    @Test
    public void test32() {
        /*
https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
Response Body // expected data
{
"bookingid": 24,
"booking": {
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
}
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

        specHerokuapp.pathParam("pp1", "booking");

        PojoHerokuappBookingdates bookingdatesPojo =
                new PojoHerokuappBookingdates("2021-06-01", "2021-06-10");

        PojoHerokuappRequestBody requestBodyPojo =
                new PojoHerokuappRequestBody("Ahmet", "bulut", 500,
                        false, bookingdatesPojo, "wifi");

        bookingdatesPojo = new PojoHerokuappBookingdates("2021-06-01", "2021-06-10");

        PojoHerokuappRequestBody bookingPojo =
                new PojoHerokuappRequestBody("Ahmet", "bulut", 500,
                        false, bookingdatesPojo, "wifi");

        PojoHerokuappResponce expectedResponceBodyPojo = new PojoHerokuappResponce(24, bookingPojo);

        //  System.out.println(expectedResponceBodyPojo);

        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON)
                .when().body(requestBodyPojo)
                .post("{pp1}");
        PojoHerokuappResponce responcePojo = response.as(PojoHerokuappResponce.class);

        assertEquals(expectedResponceBodyPojo.getBooking().getFirstname(), responcePojo.getBooking().getFirstname());
        assertEquals(expectedResponceBodyPojo.getBooking().getLastname(), responcePojo.getBooking().getLastname());
        assertEquals(expectedResponceBodyPojo.getBooking().getTotalprice(), responcePojo.getBooking().getTotalprice());
        assertEquals(expectedResponceBodyPojo.getBooking().isDepositpaid(), responcePojo.getBooking().isDepositpaid());
        assertEquals(expectedResponceBodyPojo.getBooking().getBookingdates().getCheckin(), responcePojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedResponceBodyPojo.getBooking().getBookingdates().getCheckout(), responcePojo.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedResponceBodyPojo.getBooking().getAdditionalneeds(), responcePojo.getBooking().getAdditionalneeds());

    }
}
