package tests.apiTests;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class MainApiTest extends BaseApiTest {
    @Test (priority = 1)
    public void GetSingleUserTest() {
        String endPoint = "/api/users/2";
        given()
                .when()
                .get(startPoint + endPoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test (priority = 2)
    public void GetUsersListTest() {
        String endPoint = "/api/users?page=2";
        given()
                .when()
                .get(startPoint + endPoint)
                .then()
                .log().body()
                .body("page", is(2))
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract();
    }

    @Test (priority = 3)
    public void PostCreateUserTest() {
        String endPoint = "/api/login";
        given()
                .when()
                .get(startPoint + endPoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
