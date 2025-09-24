package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.NoAlertPresentException;
import utils.ReadProperties;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final String USERNAME_INPUT_LOCATOR = "[data-test='username']";
    private final String PASSWORD_INPUT_LOCATOR = "[data-test='password']";
    private final String LOGIN_BUTTON_LOCATOR = "[data-test='login-button']";
    private final String ERROR_MESSAGE_LOCATOR = "[data-test='error']";

    private final SelenideElement usernameInput = $(USERNAME_INPUT_LOCATOR);
    private final SelenideElement passwordInput = $(PASSWORD_INPUT_LOCATOR);
    private final SelenideElement loginButton = $(LOGIN_BUTTON_LOCATOR);
    private final SelenideElement errorMessage = $(ERROR_MESSAGE_LOCATOR);

    public void login(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
        handleAlert();
    }

    public void loginWithStandardUser() {
        login(ReadProperties.getUsername(), ReadProperties.getPassword());
        handleAlert();
    }

    private void handleAlert() {
        try {
            WebDriverRunner.getWebDriver().switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            // Alert not present, continue
        }
    }

    public SelenideElement getErrorMessage() {
        return errorMessage;
    }
}
