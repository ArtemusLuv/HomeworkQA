import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MainTest {
    private static final String URL = "https://postman-echo.com";

    @BeforeEach
    void init () {
        Spec.initSpec(Spec.requestSpec(URL), Spec.responseSpec());
    }

    @Test
    void getTest () {
        given()
                .param("foo", "first")
                .param("foo2", "second")
                .when()
                .get("/get")
                .then().log().all()
                .statusCode(200)
                .body("args.foo", equalTo("first"))
                .body("args.foo2", equalTo("second"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo(URL + "/get?foo=first&foo2=second"));
    }

    @Test
    void postRawTextTest () {
        String str = "Im here!";

        given()
                .body(str)
                .post("/post")
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo(str))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-length", equalTo("8"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", equalTo(null))
                .body("url", equalTo(URL + "/post"));
    }

    @Test
    void postFormDataTest () {
        given()
        .headers("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo", "first")
                .formParam("foo2", "second")
                .when().post("/post")
                .then().log().all()
                .statusCode(200)
                .body("form.foo", equalTo("first"))
                .body("form.foo2", equalTo("second"))
                .body("json.foo", equalTo("first"))
                .body("json.foo2", equalTo("second"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo(URL + "/post"));
    }

    @Test
    void putTest () {
        String str = "Find me!";

        given()
                .body(str)
                .when()
                .put("/put")
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo(str))
                .body("json", equalTo(null))
                .body("url", equalTo(URL + "/put"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-length", equalTo("8"));
    }

    @Test
    void patchTest () {
        String str = "This is expected to be sent back as part of response body.";

        given()
                .body(str)
                .when()
                .patch("/patch")
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo(str))
                .body("json", equalTo(null))
                .body("url", equalTo(URL + "/patch"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-length", equalTo("58"));
    }

    @Test
    void deleteTest () {
        String str = "This is expected to be sent back as part of response body.";

        given()
                .body(str)
                .when()
                .delete("/delete")
                .then().log().body()
                .statusCode(200)
                .body("data", equalTo(str))
                .body("json", equalTo(null))
                .body("url", equalTo(URL + "/delete"))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-length", equalTo("58"));
    }
}    