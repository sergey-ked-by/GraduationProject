package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ReadProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = ReadProperties.getBrowserType();
        Configuration.headless = ReadProperties.isHeadless();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = ReadProperties.getTimeout() * 1000;

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        if ("true".equals(System.getenv("IS_CI"))) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--user-data-dir=/tmp/user-data-" + UUID.randomUUID());
        }

        Configuration.browserCapabilities = options;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        open("");
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
