package tests.guiTests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.AddProjectSteps;
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
        addProjectSteps.addProject();

        Assert.assertTrue(true);
    }
}
