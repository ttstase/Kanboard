package ui.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ui.elements.DashboardElements;
import ui.elements.ProjectElements;

public class ProjectSteps extends ProjectElements {
    @Step("User clicks on 'New Project' link")
    public ProjectSteps newProjectClick(){
        new DashboardElements().newProjectLink().click();
        return new ProjectSteps();
    }

    @Step("User creates a project with name '{0}'")
    public ProjectSteps createProject(String name) {
        nameField().shouldBe(Condition.visible).sendKeys(name);
        saveButton().shouldBe(Condition.visible).click();
        return new ProjectSteps();
    }

    @Step("User clicks on 'Remove' button")
    public ProjectSteps removeButtonClick() {
        removeButton().shouldBe(Condition.visible).click();
        return new ProjectSteps();
    }

    @Step("User clicks on modal confirm button")
    public void modalConfirmButtonClick() {
        modalConfirmButton().shouldBe(Condition.visible).click();
        new ProjectSteps();
    }

    @Step("User clicks on dropdown menu")
    public ProjectSteps dropdownMenuClick(){
        dropdownMenu().shouldBe(Condition.visible).click();
        return new ProjectSteps();
    }

    @Step("User clicks on 'Add a new task' button")
    public ProjectSteps configProjButtonClick(){
        configProjButton().shouldBe(Condition.visible).click();
        return new ProjectSteps();
    }
}