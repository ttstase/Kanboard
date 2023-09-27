package ui.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ui.steps.LoginSteps;
import utils.TestConfig;

public class LoginTests extends BaseTest{
    String username = TestConfig.USERNAME;
    String password = TestConfig.PASSWORD;
    String dashboardUrl = TestConfig.DASHBOARD_URL;
    private boolean isLoginSuccessful = false;

    @Test
    @Description("Positive login test")
    public void positiveLoginTest() {
        new LoginSteps()
                .openLoginPage()
                .loginByUser(username, password);
        isLoginSuccessful = true;
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), dashboardUrl
                , "The login was not successful");
    }

    @Test
    @Description("Negative login test")
    public void negativeLoginTest() {
        new LoginSteps()
                .openLoginPage()
                .loginByUser(username, "");
        Assert.assertNotEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), dashboardUrl
                , "The login was successful");
    }

    @AfterMethod
    @Description("User logs out if logged in")
    public void logOutAfterTest(ITestResult result) {
        if (isLoginSuccessful) {
            new LoginSteps()
                    .userLogsOut();
        }
    }
}