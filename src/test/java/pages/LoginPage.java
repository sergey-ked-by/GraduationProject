package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.Button;
import wrappers.Input;

public class LoginPage extends BasePage {
    protected By emailSelector = By.id("user_auth_email");
    protected By passwordSelector = By.id("user_auth_password");
    protected By loginButtonSelector = By.cssSelector("[type='submit']");
    protected By ERROR_MESSAGE_Selector= By.className("error-on-top");

    public LoginPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL);
    }

    public boolean isPageOpened() {
        try {
            return waits.getElementBy(By.className("switchLang")).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public Input getEmailField() {
        return new Input(driver, waits.getElementBy(emailSelector));
    }

    public Input getPasswordField() {
        return new Input(driver,waits.getElementBy(passwordSelector));
    }

    public Button getLoginButton() {
        return new Button(driver, waits.getElementBy(loginButtonSelector));
    }

    public WebElement getErrorMessage(){
        return waits.getElementBy(ERROR_MESSAGE_Selector);
    }
}
