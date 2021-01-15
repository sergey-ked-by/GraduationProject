package tests.guiTests;

import baseEntities.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.AddProjectSteps;
import steps.DeleteProjectSteps;
import steps.EditProjectSteps;
import steps.LoginSteps;

public class MainGuiTest extends BaseTest {

    @Test (priority = 1, description = "Login positive test.")
    @Description ("Checking for a login possibility.")
    @Link ("https://tmsgraduationproject.atlassian.net/browse/")
    @TmsLink ("1")
    @Severity (SeverityLevel.BLOCKER)
    public void LoginPositiveTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        Assert.assertTrue(true);
    }

    @Test (priority = 2, description = "Add project positive test.")
    @Description ("Checking for a add project possibility.")
    @Issue ("")
    @Severity (SeverityLevel.NORMAL)
    public void AddProjectPositiveTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        AddProjectSteps addProjectSteps = new AddProjectSteps(driver);
        addProjectSteps.addProject("Project 1");

        Assert.assertTrue(true);
    }

    @Test (priority = 3, description = "Delete project positive test.")
    @Description ("Checking for a delete project possibility.")
    @Severity (SeverityLevel.NORMAL)
    public void DeleteProjectPositiveTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        DeleteProjectSteps deleteProjectSteps = new DeleteProjectSteps(driver);
        deleteProjectSteps.deleteProject();

        Assert.assertTrue(true);
    }

    @Test (priority = 4, description = "Edit project positive test.")
    @Description ("Checking for a project parameters edit possibility.")
    public void EditProjectPositiveTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        EditProjectSteps editProjectSteps = new EditProjectSteps(driver);
        editProjectSteps.editProject();

        Assert.assertTrue(true);
    }

    @Test (priority = 5, description = "Add project negative test.")
    @Description ("Bug found: when entering a project name longer than 50 characters," +
            " the project shouldn`t have been created.")
    @Attachment()
    public void AddProjectNegativeTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        AddProjectSteps addProjectSteps = new AddProjectSteps(driver);
        addProjectSteps.addProject("12345678901234567890123456789012345678901234567890");

        Assert.assertTrue(true,
                "The number of characters in 'Project name' field shouldn`t exceed fifty and test shouldn`t " +
                        "have been passed.");
    }
}
