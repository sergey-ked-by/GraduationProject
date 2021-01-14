package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import utils.Waits;

import java.util.List;

public class UISelect implements ISelect {
    private Select select;
    private WebDriver driver;
    private By by = null;
    private WebElement webElement;
    private Waits waits;

    public UISelect(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
        this.waits = new Waits(driver);
    }

    public UISelect(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.webElement = webElement;
        this.waits = new Waits(driver);
    }

    public UISelect(UISelect newProjectDataTypeDropbox) {}

    @Override
    public boolean isMultiple() {
        return false;
    }

    @Override
    public List<WebElement> getOptions() {
        return null;
    }

    @Override
    public List<WebElement> getAllSelectedOptions() {
        return null;
    }

    @Override
    public WebElement getFirstSelectedOption() {
        return null;
    }

    @Override
    public void selectByVisibleText(String s) {
        select.selectByVisibleText(s);
    }

    @Override
    public void selectByIndex(int i) {

    }

    @Override
    public void selectByValue(String s) {

    }

    @Override
    public void deselectAll() {

    }

    @Override
    public void deselectByValue(String s) {

    }

    @Override
    public void deselectByIndex(int i) {

    }

    @Override
    public void deselectByVisibleText(String s) {

    }
}
