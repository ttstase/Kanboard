package ui.tests;

import api.steps.UserApiSteps;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.steps.LoginSteps;
import utils.TestConfig;

public class NewUserLoginTests extends BaseTest{
    String newUserName = TestConfig.NEW_USER_NAME;
    String newUserPass = TestConfig.NEW_USER_PASS;
    String dashboardUrl = TestConfig.DASHBOARD_URL;
    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;

    @BeforeMethod
    public void createUser(){
        userId = userApiSteps.createUser(newUserName, newUserPass);
    }

    @Test
    @Description("Positive login by new user test")
    public void newUserLoginTest() {
        new LoginSteps()
                .openLoginPage()
                .loginByUser(newUserName, newUserPass);
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), dashboardUrl
                , "The login was not successful");
    }

    @Test
    @Description("Negative login by new user test")
    public void negativeNewUserLoginTest() {
        new LoginSteps()
                .openLoginPage()
                .loginByUser(newUserName, "");
        Assert.assertNotEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), dashboardUrl
                , "The login was successful");
    }

    @AfterMethod
    @Description("Delete user after tests")
    public void deleteUser(){
        userApiSteps.deleteUser(userId);
    }
}