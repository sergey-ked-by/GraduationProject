package baseEntities;

import browserService.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    public ReadProperties properties;
    public String startPoint = "https://reqres.in";

    @BeforeMethod
    public void setUp() {
        properties = new ReadProperties();

        RestAssured.baseURI = properties.getApiURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONN_KEEP_ALIVE,"timeout=5", "max=1000" )
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }
}
