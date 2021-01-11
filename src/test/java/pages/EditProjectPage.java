package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProjectPage extends BasePage {
    private static String ENDPOINT = "/project";

    protected By editProjectCheckboxSelector = By.id("22002");
    protected By editProjectButtonSelector = By.cssSelector("div[class='icon-bg icon-pen']");
    protected By editProjectDescriptionFieldSelector = By.id("project_description");
    protected By editProjectSaveButtonSelector = By.cssSelector("input[value='Сохранить']");
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

    public WebElement getEditProjectCheckbox() {
        return driver.findElement(editProjectCheckboxSelector);
    }
    public WebElement getEditProjectButton() {
        return driver.findElement(editProjectButtonSelector);
    }
    public WebElement getEditProjectDescriptionField() {
        return driver.findElement(editProjectDescriptionFieldSelector);
    }
    public WebElement getEditProjectSaveButton() {
        return driver.findElement(editProjectSaveButtonSelector);
    }

    public WebElement getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE_Selector);
    }
}
