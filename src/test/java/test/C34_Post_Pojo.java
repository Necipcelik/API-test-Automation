package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.pojosHavaDurumu.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class C34_Post_Pojo {
    @Test
    public void test34() {
        /*
        https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0 url’ine
          bir post request gonderdigimizde donen response’un asagidaki
           body’ye sahip oldugunu test ediniz

         */
        String url = "  https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0";

        Coord coordPojo = new Coord(-0.1257f, 51.5085f);

        List<Weather> weatherList = new ArrayList<>();
        Weather weatherPojo = new Weather(800, "Clear", "clear sky", "01d");
        weatherList.add(weatherPojo);
        Main mainPojo = new Main(287.75f, 286.39f, 285.85f, 289.26f, 1020, 43);
        Wind windPojo = new Wind(2.57f, 0);
        Sys sysPojo = new Sys(2, 268730, "GB", 1680844983, 1680892922);
        Clouds cloudsPojo = new Clouds(6);

        pojosHavaDurumu exeptedResponceBody=new pojosHavaDurumu(coordPojo,weatherList,"stations",mainPojo,1000,
                windPojo,cloudsPojo,1680879272,sysPojo,3600,2643743,"London",200);

        Response response=given().when().post(url);

        pojosHavaDurumu responcePojo=response.as(pojosHavaDurumu.class);

        JsonPath responceJP=response.jsonPath();
        Assert.assertEquals(exeptedResponceBody.getCoord().getLat(),responceJP.get("coord.lat"));
        Assert.assertEquals(exeptedResponceBody.getCoord().getLon(),responceJP.get("coord.lon"));
        Assert.assertEquals(exeptedResponceBody.getBase(),responceJP.get("base"));
        Assert.assertEquals(exeptedResponceBody.getSys().getCountry(),responceJP.get("sys.country"));
        Assert.assertEquals(exeptedResponceBody.getName(),responceJP.get("name"));


    }
}
