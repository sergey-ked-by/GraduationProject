package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    private static String ENDPOINT = "/project";

    protected By addProjectButtonSelector = By.cssSelector("div[class='icon-bg icon-plus']");
    protected By newProjectNameFieldSelector = By.id("project_name");
    protected By newProjectDataTypeSelector = By.id("project_date_type");
    protected By newProjectSaveButtonSelector = By.cssSelector("input[value='Сохранить']");
    protected By ERROR_MESSAGE_Selector= By.className("error-on-top");

    public AddProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {
        try {
            return waits.getElementBy(By.className("switchLang")).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getAddProjectButton() {
        return waits.getElementBy(addProjectButtonSelector);
    }

    public WebElement getNewProjectNameField() {
        return waits.getElementBy(newProjectNameFieldSelector);
    }

    public WebElement getNewProjectDataTypeDropbox() {
        return waits.getElementBy(newProjectDataTypeSelector);
    }

    public WebElement getNewProjectSaveButton() {
        return waits.getElementBy(newProjectSaveButtonSelector);
    }

    public WebElement getErrorMessage(){
        return waits.getElementBy(ERROR_MESSAGE_Selector);
    }
}
