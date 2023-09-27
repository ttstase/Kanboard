package ui.tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.elements.ProjectElements;
import ui.steps.LoginSteps;
import ui.steps.ProjectSteps;
import utils.TestConfig;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class ProjectTests extends BaseTest {

    String username = TestConfig.USERNAME;
    String password = TestConfig.PASSWORD;
    String projectName = TestConfig.PROJECT_NAME;

    @BeforeMethod
    @Description("User logs in before testing")
    public void logIn() {
        new LoginSteps()
                .openLoginPage()
                .loginByUser(username, password);
    }

    @Test
    @Description("Positive project creating test")
    public void positiveCreateProjectTest() {
        new ProjectSteps()
                .newProjectClick()
                .createProject(projectName);
        SelenideElement projectTitle = new ProjectElements().projectTitle().shouldBe(visible);
        projectTitle.shouldHave(text(projectName));
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