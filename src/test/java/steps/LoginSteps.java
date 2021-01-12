package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void login(String username, String psw) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.getEmailField().sendKeys(username);
        loginPage.getPasswordField().sendKeys(psw);
        loginPage.getLoginButton().submit();
    }
}
