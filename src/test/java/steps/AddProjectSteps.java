package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.AddProjectPage;

public class AddProjectSteps {
    private WebDriver driver;
    private String projectName;

    public AddProjectSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void addProject(String projectName) {
        this.projectName = projectName;
        AddProjectPage addProjectPage = new AddProjectPage(driver, true);
        addProjectPage.getAddProjectButton().click();
        addProjectPage.getNewProjectNameField().sendKeys(projectName);
        Select select = new Select(addProjectPage.getNewProjectDataTypeDropbox());
        select.selectByIndex(1);
        addProjectPage.getNewProjectSaveButton().submit();
    }
}
