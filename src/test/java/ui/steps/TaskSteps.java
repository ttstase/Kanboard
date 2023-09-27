package ui.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ui.elements.TaskElements;

public class TaskSteps extends TaskElements {

    @Step("User clicks on dropdown menu")
    public TaskSteps dropdownMenuClick(){
        dropdownMenu().shouldBe(Condition.visible).click();
        return new TaskSteps();
    }

    @Step("User clicks on 'Add a new task' button")
    public TaskSteps addANewTaskButtonClick(){
        addANewTaskButton().shouldBe(Condition.visible).click();
        return new TaskSteps();
    }

    @Step("User creates task with a title '{0}', description '{1}'")
    public void addNewTask(String title, String description){
        titleField().shouldBe(Condition.visible).sendKeys(title);
        descriptionField().shouldBe(Condition.visible).sendKeys(description);
        saveButton().shouldBe(Condition.visible).click();
        new TaskSteps();
    }

    @Step("User closes task")
    public void closeTask() {
        taskDropDown().shouldBe(Condition.visible).click();
        closeTaskButton().shouldBe(Condition.visible).click();
        confirmButton().shouldBe(Condition.visible).click();
        new TaskSteps();
    }

    @Step("User clicks on list button")
    public TaskSteps listButtonClick() {
        listButton().shouldBe(Condition.visible).click();
        return new TaskSteps();
    }
}