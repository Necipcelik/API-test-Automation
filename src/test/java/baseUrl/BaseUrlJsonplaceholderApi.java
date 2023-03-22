package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlJsonplaceholderApi {
  protected   RequestSpecification specJsonPlaceholder;
    @Before
    public void setup(){

        specJsonPlaceholder =new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();
    }





}
