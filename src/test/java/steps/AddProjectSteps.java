package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.AddProjectPage;

public class AddProjectSteps {
    private WebDriver driver;

    public AddProjectSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void addProject() {
        AddProjectPage addProjectPage = new AddProjectPage(driver, true);
        addProjectPage.getAddProjectButton().click();
        addProjectPage.getNewProjectNameField().sendKeys("Project 1");
        Select select = new Select(addProjectPage.getNewProjectDataTypeDropbox());
        select.selectByIndex(1);
        addProjectPage.getNewProjectSaveButton().click();
    }
}
