package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.Button;
import wrappers.Checkbox;
import wrappers.Input;

public class EditProjectPage extends BasePage {
    private static String ENDPOINT = "/project";

    protected By editProjectCheckboxSelector = By.cssSelector("div.prj:nth-child(1)>span.checkbox:nth-child(1)>input");
    protected By editProjectButtonSelector = By.cssSelector("div[class='icon-bg icon-pen']");
    protected By editProjectDescriptionFieldSelector = By.id("project_description");
    protected By editProjectSaveButtonSelector = By.cssSelector("[type='submit']");
    protected By ERROR_MESSAGE_Selector= By.className("error-on-top");

    public EditProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {
        return waits.isElementDisplayed(By.id("span_edit_button"));
    }

    public Checkbox getEditProjectCheckbox() {
        return new Checkbox(driver, waits.getElementBy(editProjectCheckboxSelector));
    }

    public Button getEditProjectButton() {
        return new Button(driver, waits.getElementBy(editProjectButtonSelector));
    }

    public Input getEditProjectDescriptionField() {
        return new Input(driver, waits.getElementBy(editProjectDescriptionFieldSelector));
    }

    public Button getEditProjectSaveButton() {
        return new Button(driver, waits.getElementBy(editProjectSaveButtonSelector));
    }

    public WebElement getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE_Selector);
    }
}
