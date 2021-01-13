package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {
    protected By emailSelector = By.id("user_auth_email");
    protected By passwordSelector = By.id("user_auth_password");
    protected By loginButtonSelector = By.xpath("//input[@value='Войти']");
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

    public WebElement getEmailField() {
        return waits.getElementBy(emailSelector);
    }

    public WebElement getPasswordField() {
        return waits.getElementBy(passwordSelector);
    }

    public WebElement getLoginButton() {
        return waits.getElementBy(loginButtonSelector);
    }

    public WebElement getErrorMessage(){
        return waits.getElementBy(ERROR_MESSAGE_Selector);
    }
}
