package ui.tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.steps.LoginSteps;
import ui.steps.ProjectSteps;
import ui.steps.TaskSteps;
import utils.TestConfig;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class CloseTaskTest extends BaseTest{
    String username = TestConfig.USERNAME;
    String password = TestConfig.PASSWORD;
    String projectName = TestConfig.PROJECT_NAME;
    String taskTitle = TestConfig.TASK_TITLE;
    String taskDescription = TestConfig.TASK_DESCRIPTION;
    private final static String alertMessage = "No tasks found.";

    @BeforeMethod
    @Description("Setup data before tests")
        public void logIn() {
        new LoginSteps()
                .openLoginPage()
                .loginByUser(username, password);
        new ProjectSteps()
                .newProjectClick()
                .createProject(projectName);
        new TaskSteps()
                .dropdownMenuClick()
                .addANewTaskButtonClick()
                .addNewTask(taskTitle, taskDescription);
    }

    @Test
    @Description("Positive task closing test")
    public void positiveCreateTaskTest(){
        new TaskSteps()
                .listButtonClick()
                .closeTask();
        SelenideElement alertMessageText = new TaskSteps().alertMessage().shouldBe(visible);
        alertMessageText.shouldHave(text(alertMessage));
    }

    @AfterMethod
    @Description("Clearing data and logout after tests")
    public void logout() {
        new ProjectSteps()
                .dropdownMenuClick()
                .configProjButtonClick()
                .removeButtonClick()
                .modalConfirmButtonClick();
        new LoginSteps()
                .userLogsOut();
    }
}