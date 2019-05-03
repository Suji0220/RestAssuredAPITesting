package getRequestTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateResponseCodeTest {

    @Test
    public void validateResonseCode() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        Assert.assertTrue(response.getStatusCode() == 200);
        System.out.println(response.getStatusCode());
        validateData(response);

    }

    private void validateData(Response response) {
        List<Map<String, ?>> actualData = response.jsonPath().getList("data");
        List<Map<String, ?>> expectedResult = new ArrayList<>();

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Map<String, String> map3 = new HashMap<>();

        map1.put("id","4");
        map1.put("first_name","Eve");
        map1.put("last_name","Holt");

        map2.put("id","5");
        map2.put("first_name","Charles");
        map2.put("last_name","Morris");

        map3.put("id","6");
        map3.put("first_name","Tracey");
        map3.put("last_name","Ramos");

        expectedResult.add(map1);
        expectedResult.add(map2);
        expectedResult.add(map3);

        int dataSize = actualData.size();
        System.out.println("The data size is: " + dataSize);

        for (int i = 0; i < dataSize; i++) {
            System.out.println("Id : " + actualData.get(i).get("id").toString());
            System.out.println("First Name: " + actualData.get(i).get("first_name").toString());
            System.out.println("Last Name: " + actualData.get(i).get("last_name").toString());
            Assert.assertEquals(expectedResult.get(i).get("id").toString(), actualData.get(i).get("id").toString());
            Assert.assertEquals(expectedResult.get(i).get("first_name").toString(), actualData.get(i).get("first_name").toString());

        }
            Assert.assertEquals("4", actualData.get(1).get("id").toString() );
        }






}


/*    System.out.println("--------------------------");

        System.out.println(response.contentType());
        System.out.println("--------------------------");
        System.out.println(response.headers());
        System.out.println("--------------------------");
        System.out.println(response.statusLine());
        System.out.println("--------------------------");
        System.out.println(response.xmlPath());
        System.out.println("--------------------------");
        System.out.println(response.cookies());
        System.out.println("--------------------------");
        System.out.println(response.getClass());
        System.out.println("--------------------------");

        System.out.println(response.sessionId());
        System.out.println("--------------------------");

        System.out.println(response.prettyPrint());*/

//        String json = response.asString();
//
//        System.out.println(json);
//        JsonPath jp = new JsonPath(json);
// Assert.assertEquals();

      /*  String json = res.asString();
        JsonPath jp = new JsonPath(json);
        assertEquals("onur@swtestacademy", jp.get("email"));
        assertEquals("Onur", jp.get("firstName"));
        assertEquals("Baskirt", jp.get("lastName"));*/



       /* "id": 4,
                "first_name": "Eve",
                "last_name": "Holt",
                "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"*/


