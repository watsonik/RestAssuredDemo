import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

/**
 * @author Ihar_Sakun
 */
public class DataDrivenExamples {

    @DataProvider(name = "DataForPost")
    public Object[][] dataForPost() {
//        Object[][] data = new Object[2][3];
//        data[0][0] = "Albert";
//        data[0][1] = "Einstein";
//        data[0][2] = 2;
//        data[1][0] = "Thomas";
//        data[1][1] = "Edison";
//        data[1][2] = 1;
//        return data;
        return new Object[][]{
            {"Graham","Bell",1},
            {"Henry","Ford",2},
        };
    }

    @Test(dataProvider = "DataForPost")
    public void test_post(String firstName, String lastName, int subjectId) {
        JsonObject request = new JsonObject();
        request.addProperty("firstName", firstName);
        request.addProperty("lastName", lastName);
        request.addProperty("subjectId", subjectId);
        baseURI = "http://localhost:3000";
        given().
                contentType(ContentType.JSON).accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request).
                when().
                post("/users").
                then().
                statusCode(201).log().all();
    }

}
