package baseEntities;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import utils.ReadProperties;

public class BaseApiTest {

    @BeforeSuite
    public void setUp() {
        RestAssured.baseURI = ReadProperties.getApiUrl();
    }
}
