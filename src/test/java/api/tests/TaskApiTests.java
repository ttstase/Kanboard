package api.tests;

import api.steps.ProjectApiSteps;
import api.steps.TaskApiSteps;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.steps.LoginSteps;
import utils.TestConfig;

public class TaskApiTests {
    String username = TestConfig.USERNAME;
    String password = TestConfig.PASSWORD;
    String projectName = TestConfig.PROJECT_NAME;
    String projectDescription = TestConfig.PROJECT_DESCRIPTION;
    String taskTitle = TestConfig.TASK_TITLE;
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    TaskApiSteps taskApiSteps = new TaskApiSteps();
    private String projectId;
    private String taskId;

    @BeforeMethod
    @Description("Setup data before tests")
    public void prepareDataForTest(){
        new LoginSteps()
                .openLoginPage()
                .loginByUser(username, password);
        projectId = projectApiSteps.createProject(projectName, projectDescription);
    }

    @Test
    @Description("Positive create Task test")
    public void newTaskTest() {
        taskId = taskApiSteps.createTask(taskTitle, projectId);
        Assert.assertNotEquals(taskId, false, "Task not created");
        System.out.println(taskId);
    }

    @AfterMethod(alwaysRun = true)
    @Description("Clearing data after tests")
    public void removeTaskAfterTest() {
        taskApiSteps.deleteTask(taskId);
        projectApiSteps.deleteProject(projectId);
        LoginSteps loginPage = new LoginSteps();
        loginPage.userLogsOut();
    }
}