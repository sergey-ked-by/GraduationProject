package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ReadProperties;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = ReadProperties.getBrowserType();
        Configuration.headless = ReadProperties.isHeadless();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = ReadProperties.getTimeout() * 1000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        open("");
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}