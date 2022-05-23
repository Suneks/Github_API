package tests.api.steps;

import io.qameta.allure.Step;
import org.json.JSONObject;
import tests.api.model.Repo;

import static tests.api.GitHubApiTests.USER;
import static tests.api.steps.Spec.prepareRequest;


public class GitHubApiRepoSteps {
    @Step("Создание репозитория")
    public void createRepo(Repo repo) {
        prepareRequest()
                .log().all()
                .body(repo)
                .post("/user/repos")
                .then()
                .log().all()
                .statusCode(201);
    }

    @Step("Проверка существования репозитория")
    public void checkExistsRepo(Repo repo) {
        prepareRequest()
                .log().all()
                .get("/repos/" + USER + "/" + repo.getName())
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .jsonPath()
                .getString("full_name").equals(USER + "/" + repo.getName());
    }

    @Step("Изменение имени репозитория")
    public void editNameRepo(Repo repo, Repo newRepo) {
        prepareRequest()
                .log().all()
                .body(new JSONObject().put("name", newRepo.getName()).toString())
                .patch("/repos/" + USER + "/" + repo.getName())
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("full_name").equals(USER + "/" + newRepo.getName());
    }

    @Step("Поиск репозитория")
    public int searchRepo(Repo repo) {
        return prepareRequest()
                .queryParam("q", USER + "/" + repo.getName())
                .queryParam("per_page", "1")

                .when()
                .log().all()
                .get("/search/repositories")

                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("total_count");
    }

    @Step("Удаление репозитория")
    public void deleteRepo(Repo repo) {
        prepareRequest()
                .log().all()
                .delete("/repos/" + USER + "/" + repo.getName())
                .then()
                .log().all()
                .statusCode(204);
    }


}
