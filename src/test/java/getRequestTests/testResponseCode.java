package getRequestTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testResponseCode {

    @Test
    public void testResponseCode()
    {
        Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");

        String data = response.asString();
        System.out.println("Data is: " + data);

        int code = response.getStatusCode();
        System.out.println("Status code is: " + code);
        Assert.assertEquals(code, 200);

        System.out.println("Response time: " + response.getTime());
    }
}
