package postRequestTests;

import groovy.json.JsonException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateRegisterUser {

    @Test
    public void validateCreateRequest(){
        /*Response response = RestAssured.post("https://reqres.in/api/users/api/register");
        //response.*/
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject requestJson = new JSONObject();
        try{
            requestJson.put("email", "sydney@fife");
            requestJson.put("password", "pistol");
        }catch(JsonException e){
            e.printStackTrace();
        }

        request.body(requestJson.toString());
        Response responseRegister = request.post("https://reqres.in/api/register");
        System.out.println("Response Body: " + responseRegister.getBody().asString());
        Assert.assertEquals(responseRegister.getStatusCode(), 201);
    }

    @Test
    public void validateRegisterUserInValidData()
    {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject requestJson = new JSONObject();
        try{
            requestJson.put("email", "sydney@fife");
        }catch (JsonException e){
            e.printStackTrace();
        }
        request.body(requestJson.toString());
        Response responseRegister = request.post("https://reqres.in/api/register");
        System.out.println(responseRegister.getStatusCode());
        System.out.println("Response Body: " + responseRegister.getBody().asString());

       Assert.assertEquals(responseRegister.getStatusCode(), 400);

    }

    @Test
    public void validateLoginForSuccessful(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject requestJson = new JSONObject();
        try{
            requestJson.put("name", "morpheus");
            requestJson.put("job", "leader");
        }catch(JsonException e){
            e.printStackTrace();
        }

        request.body(requestJson.toString());
        Response responseRegister = request.post("https://reqres.in//api/login");
        System.out.println("Response Body: " + responseRegister.getBody().asString());
        Assert.assertEquals(responseRegister.getStatusCode(), 201);
    }



}
