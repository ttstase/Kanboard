package ui.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardElements {
    public SelenideElement newProjectLink() {
        return $x("//div[@class='page-header']/ul/li/a[@href='/project/create']");
    }
}