package api.tests;

import api.steps.UserApiSteps;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class UserApiTests {
    private final static String NEW_USER_NAME = "user111";
    private final static String NEW_USER_PASS = "pass111";
    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;


    @Test
    @Description("Positive create new user test")
    public void newUserLoginTest() {
        userId = userApiSteps.createUser(NEW_USER_NAME, NEW_USER_PASS);
        Assert.assertNotEquals(userId, false, "User is not created");
        System.out.println(userId);
    }

    @AfterMethod(alwaysRun = true)
    @Description("Clearing data after tests")
    public void removeUserAfterTest() {
        userApiSteps.deleteUser(userId);
    }
}