package baseEntities;

import browserService.BrowserService;
import browserService.ReadProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
//import utils.Listener;

//@Listeners(Listeners.class)

public class BaseTest {
    public WebDriver driver;
    public ReadProperties readProperties = new ReadProperties();


    public void BaseTest() {}

    @BeforeClass
    public void SetUp() {
        this.driver = new BrowserService().getDriver();
        driver.get(new ReadProperties().getURL());

    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}
//    @BeforeMethod
//    public void SetUp() {
//        this.driver = new BrowserService().getDriver();
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        driver.get(new ReadProperties().getURL());
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

