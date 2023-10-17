package ui.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ui.elements.MainElements;
import utils.TestConfig;

import static com.codeborne.selenide.Selenide.open;

public class MainPage extends MainElements {

    String loginPageUrl = TestConfig.LOGIN_PAGE_URL;

    @Step("Opening login page")
    public MainPage openLoginPage() {
        open(loginPageUrl);
        return new MainPage();
    }

    @Step("Asserting main section")
    public MainPage assertMainSectionIsOpened() {
        mainSection().shouldBe(Condition.visible);
        return this;
    }
}