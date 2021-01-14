package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownSelect {
    private UISelect uiSelect;


    public DropDownSelect(WebDriver driver, By by) {
        uiSelect = new UISelect(driver, by);
    }

    public DropDownSelect(WebDriver driver, WebElement webElement){
        uiSelect = new UISelect(driver, webElement);
    }

    public void selectByVisibleText(String visibleText) {
        uiSelect.selectByVisibleText(visibleText);
    }
}
