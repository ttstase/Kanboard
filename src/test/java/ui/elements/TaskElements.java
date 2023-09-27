package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TaskElements {

    public SelenideElement dropdownMenu() {
        return $x("//i[@class='fa fa-cog']");
    }

    public SelenideElement addANewTaskButton() {
        return $x("//*[@class='dropdown-submenu-open']/li/a[contains(text(), 'Add a new task')]");
    }

    public SelenideElement taskDropDown() {
        return $x("//div[@class='table-list-row color-yellow']/div/div/a[@class='dropdown-menu dropdown-menu-link-icon']");
    }

    public SelenideElement closeTaskButton() {
        return $x("//ul[@class='dropdown-submenu-open']/li/a[contains(text(), 'Close this task')]");
    }

    public SelenideElement confirmButton() {
        return $("button[id='modal-confirm-button']");
    }

    public SelenideElement titleField() {
        return $("#form-title");
    }

    public SelenideElement descriptionField() {
        return $x("//*[@name='description']");
    }

    public SelenideElement saveButton() {
        return $x("//button[@type='submit']");
    }

    public SelenideElement openTasks() {
        return $x("//*[@class='table-striped table-scrolling']/tbody/tr/td[contains(text(),'1')]");
    }

    public SelenideElement listButton() {
        return $x("//a[@class='view-listing']");
    }

    public SelenideElement alertMessage() {
        return $x("//p[@class='alert']");
    }
}