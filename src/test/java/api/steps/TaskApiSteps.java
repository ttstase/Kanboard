package api.steps;

import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.tasks.CreateTask;
import api.models.args.tasks.TaskId;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static api.methods.Tasks.CREATE_TASK;
import static api.methods.Tasks.DELETE_TASK;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class TaskApiSteps extends BaseApiSteps{

    @Step("Create a task with title '{0}', id '{1}']")
    public String createTask(String title, String project_id) {
        CreateTask args = CreateTask.builder()
                .title(title)
                .project_id(project_id)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(CREATE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

    @Step("Delete a task with id '{0}'")
    public boolean deleteTask(String taskId) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new TaskId((Integer.valueOf(taskId))))
                .method(DELETE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }
}