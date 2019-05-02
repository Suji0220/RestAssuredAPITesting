package postRequestTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ValidateCreateRequest {

    @Test
    public void validateCreateRequest(){
        Response response = RestAssured.post("https://reqres.in/api/users");
        //response.

    }



    /*@Test
    public void submitForm() {
        RestAssured.baseURI = "https://www.example.com";
        given().urlEncodingEnabled(true)
                .param("username", "user@site.com")
                .param("password", "Pas54321")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/login")
                .then().statusCode(200);
    }*/




}
