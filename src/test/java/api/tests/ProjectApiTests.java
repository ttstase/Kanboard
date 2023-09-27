package api.tests;

import api.steps.ProjectApiSteps;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.steps.LoginSteps;
import utils.TestConfig;

public class ProjectApiTests {
    String username = TestConfig.USERNAME;
    String password = TestConfig.PASSWORD;
    String projectName = TestConfig.PROJECT_NAME;
    String projectDescription = TestConfig.PROJECT_DESCRIPTION;
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    private String projectId;

    @BeforeMethod
    @Description("Setup data before tests")
    public void prepareDataForTest(){
        new LoginSteps()
                .openLoginPage()
                .loginByUser(username, password);
    }

    @Test
    @Description("Positive create project test")
    public void newProjectTest() {
        projectId = projectApiSteps.createProject(projectName, projectDescription);
        Assert.assertNotEquals(projectId, false, "Project is not created");
        System.out.println(projectId);
    }

    @AfterMethod(alwaysRun = true)
    @Description("Clearing data after tests")
    public void removeProjectAfterTest() {
        projectApiSteps.deleteProject(projectId);
        LoginSteps loginPage = new LoginSteps();
        loginPage.userLogsOut();
    }
}