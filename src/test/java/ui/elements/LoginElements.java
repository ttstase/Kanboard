package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginElements {
    public SelenideElement userField() {
        return $("#form-username");
    }

    public SelenideElement passwordField() {
        return $("#form-password");
    }

    public SelenideElement submitButton() {
        return $x("//button[@type='submit']");
    }

    public SelenideElement singInButton() {
        return $("button[class='btn btn-blue']");
    }

    public SelenideElement failLoginMessage() {
        return $("p[class='alert alert-error']");
    }

    public SelenideElement userIcon() {
        return $(".avatar-letter");
    }

    public SelenideElement logOutIcon() {
        return $x("//ul[@class='dropdown-submenu-open']/li/a[text()='Logout']");
    }
}