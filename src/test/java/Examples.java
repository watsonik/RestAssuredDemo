import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

/**
 * @author Ihar_Sakun
 */
public class Examples {

    @Test
    public void test_get() {
        baseURI = "http://localhost:3000";
        given().get("/users").then().statusCode(200).log().all();
    }
}
