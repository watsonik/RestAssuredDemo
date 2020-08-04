import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

/**
 * @author Ihar_Sakun
 */
public class Tests_POST {

    @Test
    public void test_1_post() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "Ihar");
//        map.put("job", "epam");
//        System.out.println(map);
        JsonObject request = new JsonObject();
        request.addProperty("name", "Ihar");
        request.addProperty("job", "epam");
        System.out.println(request);
        given().body(request).post("https://reqres.in/api/users").then().statusCode(201).log().all();
    }

    @Test
    public void test_1_put() {
        JsonObject request = new JsonObject();
        request.addProperty("name", "Ihar");
        request.addProperty("job", "epam");
        System.out.println(request);
        given().body(request).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();
    }
}
