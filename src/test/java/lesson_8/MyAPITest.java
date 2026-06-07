package lesson_8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class MyAPITest {
    String baseURI = "https://postman-echo.com";

    @Test
    @DisplayName("Проверка GET-запроса")
    public void testingGETRequest() {
        given()
                .baseUri(baseURI)
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .and()
                .body("args.foo1", equalTo("bar1"))
                .and()
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    @DisplayName("Проверка POST-запроса Raw Text")
    public void testingPOSTRequest1() {
        given()
                .baseUri(baseURI)
                .contentType("application/json")
                .body("{\"test\": \"value\"}")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .and()
                .body("json.test", equalTo("value"));
    }

    @Test
    @DisplayName("Проверка POST-запроса Form Data")
    public void testingPOSTRequest2() {
        given()
                .baseUri(baseURI)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .and()
                .body("form.foo1", equalTo("bar1"))
                .and()
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    @DisplayName("Проверка PUT-запроса")
    public void testingPUTRequest() {
        given()
                .baseUri(baseURI)
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .and()
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    @DisplayName("Проверка PATCH-запроса")
    public void testingPATCHRequest() {
        given()
                .baseUri(baseURI)
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .and()
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    @DisplayName("Проверка DELETE-запроса")
    public void testingDeleteRequest() {
        given()
                .baseUri(baseURI)
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .and()
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}
