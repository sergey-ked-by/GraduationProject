package browserService;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BrowserService {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType = null;

    public BrowserService() {
        String browserName = new ReadProperties().getBrowserName();

        switch (browserName.toLowerCase()) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setHeadless(new ReadProperties().isHeadless());

                driver = new ChromeDriver(chromeOptions);
                //driver.manage().window().maximize();
                 break;

            case "firefox":
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-gpu");

                driver = new FirefoxDriver(firefoxOptions);
                //driver.manage().window().maximize();
                break;

            case "ie":
                break;

            case "edge":
                driverManagerType = DriverManagerType.EDGE;
                WebDriverManager.getInstance(driverManagerType).setup();
                EdgeOptions edgeOptions = new EdgeOptions();

                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                System.out.println("Browser is not supported.");
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}

