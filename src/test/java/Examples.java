import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

/**
 * @author Ihar_Sakun
 */
public class Examples {

    @Test
    public void test_get() {
        baseURI = "http://localhost:3000";
        given().
                param("name", "Automation").
                get("/subjects").then().statusCode(200).log().all();
    }

    @Test
    public void test_post() {
        JsonObject request = new JsonObject();
        request.addProperty("firstName", "Tom");
        request.addProperty("lastName", "Cooper");
        request.addProperty("subjectId", "1");
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

    @Test
    public void test_patch() {
        JsonObject request = new JsonObject();
        request.addProperty("lastName", "Shephered");
        baseURI = "http://localhost:3000";
        given().
                contentType(ContentType.JSON).accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request).
                when().
                patch("/users/4").
                then().
                statusCode(200).log().all();
    }

    @Test
    public void test_put() {
        JsonObject request = new JsonObject();
        request.addProperty("firstName", "Mary");
        request.addProperty("lastName", "Jane");
        request.addProperty("subjectId", "1");
        baseURI = "http://localhost:3000";
        given().
                contentType(ContentType.JSON).accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request).
                when().
                put("/users/4").
                then().
                statusCode(200).log().all();
    }

    @Test
    public void test_delete() {
        baseURI = "http://localhost:3000";
        when().
                delete("/users/4").then().statusCode(200);
    }
}
