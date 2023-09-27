package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectElements {

    public SelenideElement projectTitle() {
        return $x("//span[contains(text(), 'Project-1')]");
    }

    public SelenideElement removeButton() {
        return $x("//a[contains(text(), 'Remove')]");
    }

    public SelenideElement modalConfirmButton() {
        return $("#modal-confirm-button");
    }

    public SelenideElement dropdownMenu() {
        return $x("//i[@class='fa fa-cog']");
    }

    public SelenideElement configProjButton() {
        return $x("//*[@class='dropdown-submenu-open']/li/a[contains(text(), 'Configure this project')]");
    }

    public SelenideElement nameField() {
        return $("#form-name");
    }

    public SelenideElement saveButton() {
        return $x("//button[@type='submit']");
    }
}