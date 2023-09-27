package ui.tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.elements.CommentElements;
import ui.steps.CommentSteps;
import ui.steps.LoginSteps;
import ui.steps.ProjectSteps;
import ui.steps.TaskSteps;
import utils.TestConfig;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class CommentTests extends BaseTest {
    String username = TestConfig.USERNAME;
    String password = TestConfig.PASSWORD;
    String projectName = TestConfig.PROJECT_NAME;
    String taskTitle = TestConfig.TASK_TITLE;
    String taskDescription = TestConfig.TASK_DESCRIPTION;
    private final static String COMMENT = "Comment-1";
    private final static String commentList = "1";

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
        new TaskSteps().listButtonClick();
    }

    @Test
    @Description("Positive add comment test")
    public void positiveAddCommentTest(){
        new CommentSteps()
                .taskDropDownClick()
                .addNewCommentClick()
                .fillingCommentField(COMMENT)
                .saveButtonClick();

        SelenideElement addedComment = new CommentElements().commentListController().shouldBe(visible);
        addedComment.shouldHave(text(commentList));
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