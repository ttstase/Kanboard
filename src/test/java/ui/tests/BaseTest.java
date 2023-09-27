package ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    @Description("Starting browser before testing")
    public void setUp() {

        String browser = System.getProperty("browser");
        String headless = System.getProperty("headless");
        Configuration.browser = browser;
//        Configuration.browser = "firefox";
//        Configuration.browser = "chrome";
//        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        if (headless.equals("true")) {
            Configuration.headless = true;
        }
    }

    @AfterMethod
    @Description("Closing browser after tests")
    public void cleanUp () {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}