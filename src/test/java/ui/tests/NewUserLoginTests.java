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
    private final static String NEW_USER_NAME = "user111";
    private final static String NEW_USER_PASS = "pass111";
    String dashboardUrl = TestConfig.DASHBOARD_URL;
    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;

    @BeforeMethod
    public void createUser(){
        userId = userApiSteps.createUser(NEW_USER_NAME, NEW_USER_PASS);
    }

    @Test
    @Description("Positive login by new user test")
    public void newUserLoginTest() {
        new LoginSteps()
                .openLoginPage()
                .loginByUser(NEW_USER_NAME, NEW_USER_PASS);
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), dashboardUrl
                , "The login was not successful");
    }

    @Test
    @Description("Negative login by new user test")
    public void negativeNewUserLoginTest() {
        new LoginSteps()
                .openLoginPage()
                .loginByUser(NEW_USER_NAME, "");
        Assert.assertNotEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), dashboardUrl
                , "The login was successful");
    }

    @AfterMethod
    @Description("Delete user after tests")
    public void deleteUser(){
        userApiSteps.deleteUser(userId);
    }
}