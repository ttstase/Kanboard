package ui.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ui.elements.CommentElements;

public class CommentSteps extends CommentElements {
    @Step("User clicks on 'task dropdown' element")
    public CommentSteps taskDropDownClick() {
        taskDropDown().shouldBe(Condition.visible).click();
        return new CommentSteps();
    }

    @Step("User clicks on 'Add a new comment' button")
    public CommentSteps addNewCommentClick() {
        addNewCommentButton().shouldBe(Condition.visible).click();
        return new CommentSteps();
    }

    @Step("User fills out a 'comment' field with '{0}'")
    public CommentSteps fillingCommentField(String comment){
        commentField().shouldBe(Condition.visible).sendKeys(comment);
        return new CommentSteps();
    }

    @Step("User clicks on 'Save' button")
    public CommentSteps saveButtonClick() {
        saveButton().shouldBe(Condition.visible).click();
        return new CommentSteps();
    }
}