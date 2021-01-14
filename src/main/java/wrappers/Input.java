package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input {
    private UIElement uiElement;

    public Input(WebDriver driver, By by) {
        uiElement = new UIElement(driver, by);
    }

    public Input(WebDriver driver, WebElement webElement){
        uiElement = new UIElement(driver, webElement);
    }

    public void sendKeys(String username) {
        uiElement.sendKeys(username);
    }
}
