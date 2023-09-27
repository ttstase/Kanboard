package ui.tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.elements.TaskElements;
import ui.steps.LoginSteps;
import ui.steps.ProjectSteps;
import ui.steps.TaskSteps;
import utils.TestConfig;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class NewTaskTest extends BaseTest{
    String username = TestConfig.USERNAME;
    String password = TestConfig.PASSWORD;
    String projectName = TestConfig.PROJECT_NAME;
    String taskTitle = TestConfig.TASK_TITLE;
    String taskDescription = TestConfig.TASK_DESCRIPTION;
    private final static String openTasks = "1";

    @BeforeMethod
    @Description("Setup data before tests")
    public void logIn() {
        new LoginSteps()
                .openLoginPage()
                .loginByUser(username, password);
        new ProjectSteps()
                .newProjectClick()
                .createProject(projectName);
    }

    @Test
    @Description("Positive task creating test")
    public void positiveCreateTaskTest(){
        new TaskSteps()
                .dropdownMenuClick()
                .addANewTaskButtonClick()
                .addNewTask(taskTitle, taskDescription);

        SelenideElement openTask = new TaskElements().openTasks().shouldBe(visible);
        openTask.shouldHave(text(openTasks));
    }

    @AfterMethod
    @Description("Clearing data and logout after tests")
    public void logout() {
        new ProjectSteps()
                .removeButtonClick()
                .modalConfirmButtonClick();
        new LoginSteps()
                .userLogsOut();
    }
}