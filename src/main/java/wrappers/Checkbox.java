package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {
    private UIElement uiElement;

    public Checkbox (WebDriver driver, By by) {
        uiElement = new UIElement(driver, by);
    }

    public Checkbox (WebDriver driver, WebElement webElement) {
        uiElement = new UIElement(driver, webElement);
    }

    public void click() {
        uiElement.click();
    }
}
