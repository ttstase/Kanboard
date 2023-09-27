package api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.users.CreateUser;
import api.models.args.users.UserId;

import static api.enums.UserRoles.USER;
import static api.methods.Users.*;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class UserApiSteps extends BaseApiSteps {
    @Step("Create a user with username '{0}', password '{1}'")
    public String createUser(String username, String pass) {
        CreateUser args = CreateUser.builder()
                .username(username)
                .name(username)
                .password(pass)
                .email(username + "@mail.com")
                .role(USER.getRole())
                .build();

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(CREATE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
    @Step("Delete a user with id '{0}'")
    public boolean deleteUser(String userId) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new UserId(Integer.valueOf(userId)))
                .method(DELETE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }
}