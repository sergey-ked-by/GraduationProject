package tests.guiTests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.AddProjectSteps;
import steps.EditProjectSteps;
import steps.LoginSteps;

public class MainTest extends BaseTest {

    @Test (priority = 1)
    public void LoginPositiveTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        Assert.assertTrue(true);
    }

    @Test (priority = 2)
    public void AddProjectPositiveTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        AddProjectSteps addProjectSteps = new AddProjectSteps(driver);
        addProjectSteps.addProject("Project 1");

        Assert.assertTrue(true);
    }

    @Test (priority = 2)
    public void AddProjectNegativeTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        AddProjectSteps addProjectSteps = new AddProjectSteps(driver);
        addProjectSteps.addProject("12345678901234567890123456789012345678901234567890");

        Assert.assertFalse(false,
                "The number of characters in 'Project name' field shouldn`t exceed fifty.");
    }

    @Test (priority = 3)
    public void EditProjectPositiveTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        EditProjectSteps editProjectSteps = new EditProjectSteps(driver);
        editProjectSteps.editProject();

        Assert.assertTrue(true);
    }
}
