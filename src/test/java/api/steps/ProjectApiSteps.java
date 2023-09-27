package api.steps;

import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.projects.CreateProject;
import api.models.args.projects.ProjectId;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static api.methods.Projects.*;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class ProjectApiSteps extends BaseApiSteps{
    @Step("Create a project with name '{0}', description '{1}'")
    public String createProject(String name, String description) {
        CreateProject args = CreateProject.builder()
                .name(name)
                .description(description)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(CREATE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

    @Step("Delete a project with id '{0}'")
    public void deleteProject(String projectId) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new ProjectId(Integer.valueOf(projectId)))
                .method(DELETE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.as(Result.class);
    }
}