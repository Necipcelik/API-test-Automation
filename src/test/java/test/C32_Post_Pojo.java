package test;

import baseUrl.BaseUrlHerokuapp;
import org.junit.Test;
import pojos.PojoHerokuappBookingdates;
import pojos.PojoHerokuappRequestBody;

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

        PojoHerokuappBookingdates bookingdatesPojo=
                new PojoHerokuappBookingdates("2021-06-01","2021-06-10");

        PojoHerokuappRequestBody requestBodyPojo=
                new PojoHerokuappRequestBody("Ahmet","bulut",500,false,bookingdatesPojo,"wifi");



    }
}
