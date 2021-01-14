package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DeleteProjectPage;

public class DeleteProjectSteps {
    private WebDriver driver;

    public DeleteProjectSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void deleteProject() {
        DeleteProjectPage deleteProjectPage = new DeleteProjectPage(driver, true);
        deleteProjectPage.getDeleteProjectCheckbox().click();
        deleteProjectPage.getDeleteProjectButton().click();
        deleteProjectPage.getDeleteConfirmationButton();
    }
}
