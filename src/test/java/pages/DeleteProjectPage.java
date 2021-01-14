package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteProjectPage extends BasePage {
    private static String ENDPOINT = "/project";

    protected By deleteProjectCheckboxSelector = By.cssSelector("div.prj:nth-child(1)>span.checkbox:nth-child(1)>input");
    protected By deleteProjectButtonSelector = By.cssSelector("div[class='icon-bg icon-exit']");
    protected By deleteConfirmationButtonSelector = By.id("popup_ok");
    protected By ERROR_MESSAGE_Selector= By.className("error-on-top");

    public DeleteProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {
        return waits.isElementDisplayed(By.id("span_edit_button"));
    }

    public WebElement getDeleteProjectCheckbox() {
        return driver.findElement(deleteProjectCheckboxSelector);
    }
    public WebElement getDeleteProjectButton() {
        return driver.findElement(deleteProjectButtonSelector);
    }
    public WebElement getDeleteConfirmationButton() {
        return driver.findElement(deleteConfirmationButtonSelector);
    }
    public WebElement getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE_Selector);
    }
}