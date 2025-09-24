package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class LoginSteps {
    private final LoginPage loginPage = new LoginPage();

    @Step("Logging in with username: {username} and password: {password}")
    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    @Step("Logging in with standard user")
    public void loginWithStandardUser() {
        loginPage.loginWithStandardUser();
    }

    @Step("Verify error message: {errorMessage}")
    public void verifyErrorMessage(String errorMessage) {
        loginPage.getErrorMessage().shouldBe(visible).shouldHave(text(errorMessage));
    }
}
