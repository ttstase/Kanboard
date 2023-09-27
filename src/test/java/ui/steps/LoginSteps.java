package ui.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ui.elements.LoginElements;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginSteps extends LoginElements {

    @Step("Opening login page")
    public LoginSteps openLoginPage() {
        open("http://localhost/login");
        return new LoginSteps();
    }

    @Step("Login by user with username '{0}', password '{1}'")
    public MainPage loginByUser(String username, String password) {
        userField().shouldBe(visible).sendKeys(username);
        passwordField().sendKeys(password);
        submitButton().click();
        return new MainPage();
    }

    @Step("User logs out")
    public void userLogsOut(){
        userIcon().shouldBe(Condition.visible).click();
        logOutIcon().shouldBe(Condition.visible).click();
    }
}