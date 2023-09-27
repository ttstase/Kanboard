package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CommentElements {
    public SelenideElement taskDropDown() {
        return $x("//div[@class='table-list-row color-yellow']/div/div/a[@class='dropdown-menu dropdown-menu-link-icon']");
    }
    public SelenideElement addNewCommentButton(){
        return $x("//ul[@class='dropdown-submenu-open']/li/a[contains(text(), 'Add a comment')]");
    }
    public SelenideElement commentField() {
        return $x("//textarea[@name='comment']");
    }
    public SelenideElement saveButton() {
        return $x("//button[@type='submit']");
    }
    public SelenideElement commentListController(){
        return $x("//a[@title='1 comment']");
    }
}