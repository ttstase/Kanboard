package api.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.models.BoardInfo;
import api.models.Result;
import api.steps.BoardApiSteps;

import java.util.List;
public class BoardApiTests {

    private final int PROJECT_ID = 102;
    @Test
    @Description("Positive check Board Api")
    public void checkBoardApi() {
        BoardApiSteps boardApiSteps = new BoardApiSteps();
        Result<List<BoardInfo>> boardInfoResult = boardApiSteps.getBoardForProject(PROJECT_ID);
        Assert.assertTrue(boardInfoResult.getResult().size() > 0, "Board request doesn't contain records");
        System.out.println(boardInfoResult.getResult().get(0).getName());
    }
}