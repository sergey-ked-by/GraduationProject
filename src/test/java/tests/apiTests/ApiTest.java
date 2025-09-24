package tests.apiTests;

import baseEntities.BaseApiTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import pojos.UserRequest;
import utils.ApiEndpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ApiTest extends BaseApiTest {

    @Test(priority = 1)
    public void getSingleUserTest() {
        given()
                .when()
                .get(ApiEndpoints.GET_SINGLE_USER.replace("{id}", "2"))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("id", is(2))
                .body("name", is("Ervin Howell"));
    }

    @Test(priority = 2)
    public void getUsersListTest() {
        given()
                .when()
                .get(ApiEndpoints.GET_USERS_LIST + "?page=2")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("[0].id", is(1));
    }

    @Test(priority = 3)
    public void createUserTest() {
        UserRequest user = UserRequest.builder()
                .name("Test User")
                .email("test@example.com")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(ApiEndpoints.CREATE_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED)
                .body("name", is(user.getName()))
                .body("email", is(user.getEmail()))
                .body("id", notNullValue());
    }

    @Test(priority = 4)
    public void updateUserTest() {
        UserRequest user = UserRequest.builder()
                .name("Updated User")
                .email("updated@example.com")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .put(ApiEndpoints.UPDATE_USER.replace("{id}", "2"))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(user.getName()))
                .body("email", is(user.getEmail()));
    }

    @Test(priority = 5)
    public void deleteUserTest() {
        given()
                .when()
                .delete(ApiEndpoints.DELETE_USER.replace("{id}", "2"))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

}
