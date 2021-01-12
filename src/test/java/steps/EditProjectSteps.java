package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.EditProjectPage;

public class EditProjectSteps {

    private WebDriver driver;

    public EditProjectSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void editProject() {
        EditProjectPage editProjectPage = new EditProjectPage(driver, true);
        editProjectPage.getEditProjectCheckbox().click();
        editProjectPage.getEditProjectButton().click();
        editProjectPage.getEditProjectDescriptionField().sendKeys("This is a description field.");
        editProjectPage.getEditProjectSaveButton().submit();
    }
}
