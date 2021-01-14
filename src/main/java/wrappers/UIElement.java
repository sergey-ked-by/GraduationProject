package wrappers;

import org.openqa.selenium.*;
import utils.Waits;

import java.util.List;

public class UIElement implements WebElement {
    private WebDriver driver;
    private By by = null;
    private WebElement webElement;
    private Waits waits;
    private JavascriptExecutor jsExecutor;

    public UIElement(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
        this.waits = new Waits(driver);
        this.webElement = waits.getElementBy(by);
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    public UIElement(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.webElement = webElement;
        this.waits = new Waits(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    @Override
    public void click() {
        try {
            webElement.click();
        } catch (ElementNotInteractableException enie) {
            jsExecutor.executeScript("arguments[0].scrollIntoView(true)", webElement);
            waits.isElementClickable(webElement);
            webElement.click();
        }
   }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
       return  webElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public UIElement findElement(By by) {
        return new UIElement(driver, webElement.findElement(by));
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return driver.getWindowHandle();
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }
}
