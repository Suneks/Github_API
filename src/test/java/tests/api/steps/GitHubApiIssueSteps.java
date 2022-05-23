package tests.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;
import tests.api.model.Issue;
import tests.api.model.Repo;

import static org.hamcrest.Matchers.equalTo;
import static tests.api.GitHubApiTests.USER;
import static tests.api.steps.Spec.prepareRequest;

public class GitHubApiIssueSteps {

    @Step("Создание Issie")
    public GitHubApiIssueSteps createIssue(Repo repo, Issue issue) {
        prepareRequest()
                .log().all()
                .body(issue)
                .post("/repos/" + USER + "/" + repo.getName() + "/issues")
                .then()
                .log().all()
                .statusCode(201);
        return this;
    }

    @Step("Проверка существования Issie")
    public GitHubApiIssueSteps checkExistsIssue(Repo repo, Issue issue) {
        prepareRequest()
                .log().all()
                .get("/repos/" + USER + "/" + repo.getName() + "/issues")
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .jsonPath()
                .getString("title").equals(USER + "/issues/" + issue.getTitle());
        return this;
    }

    @Step("Изменение названия Issue")
    public GitHubApiIssueSteps editNameIssue(Repo repo, Issue issue, Issue newIssue) {
        prepareRequest()
                .log().all()
                .body(new JSONObject().put(newIssue.getTitle(), newIssue.getBody()))
                .patch("/repos/" + USER + "/" + repo.getName() + "/issues/1")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("title").equals(USER + "/issues/" + issue.getTitle());
        return this;
    }

    @Step("Блокировка Issue")
    public GitHubApiIssueSteps lockIssue(Repo repo) {
        prepareRequest()
                .log().all()
                .put("/repos/" + USER + "/" + repo.getName() + "/issues/1/lock")
                .then()
                .log().all()
                .statusCode(204);

        Response response = prepareRequest()
                .log().all()
                .get("/repos/" + USER + "/" + repo.getName() + "/issues/1");

        response.then().body("locked", equalTo(true));
        return this;
    }
}
