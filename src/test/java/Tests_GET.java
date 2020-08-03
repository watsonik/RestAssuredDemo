import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * @author Ihar_Sakun
 */
public class Tests_GET {

    @Test
    public void test_1() {
        given()
                .header("Conten-tyType","application/json")
                .get("https://reqres.in/api/users?page=2").then().statusCode(200)
                .body("data.id[1]",equalTo(8))
                .body("data.first_name", hasItems("Lindsay"))
                .log().all();
    }

}
