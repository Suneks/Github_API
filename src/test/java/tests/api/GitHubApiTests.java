package tests.api;

import com.codeborne.selenide.Selenide;
import config.application.App;
import customAnnotations.AllureFeatures;
import customAnnotations.AutoMember;
import customAnnotations.Component;
import customAnnotations.JiraIssue;
import customAnnotations.Layer;
import customAnnotations.ManualMember;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.api.model.Issue;
import tests.api.model.Repo;
import tests.api.steps.GitHubApiIssueSteps;
import tests.api.steps.GitHubApiRepoSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Layer("api")
public class GitHubApiTests {
    GitHubApiRepoSteps repoSteps = new GitHubApiRepoSteps();
    GitHubApiIssueSteps issueSteps = new GitHubApiIssueSteps();

    public final static String BASE_URL = "https://api.github.com";
    public final static String USER = App.config.getRemoteWebUser();
    public final static String TOKEN = App.config.getRemoteWebToken();

    @Test
    @Disabled
    @DisplayName("Удаление репозитория")
    void deleteTrash() {
        Repo repo1 = new Repo("my_repo", "some_description");
        repoSteps.deleteRepo(repo1);
    }

    @Test
    @DisplayName("Создание репозитория")
    void createdRepo() {
        Repo repo1 = new Repo("my_repo", "some_description");

        repoSteps.createRepo(repo1);
        repoSteps.checkExistsRepo(repo1);
        repoSteps.deleteRepo(repo1);
    }

    @Test
    @DisplayName("Изменение названия репозитория")
    void editNameRepo() {
        Repo repo2 = new Repo("my_repo2", "some_description");
        Repo newRepo = new Repo("my_repo_edited", "some_some_description");

        repoSteps.createRepo(repo2);
        repoSteps.editNameRepo(repo2, newRepo);
        Selenide.sleep(2000);
        repoSteps.deleteRepo(newRepo);
    }

    @Test
    @DisplayName("Поиск репозитория до и после создания")
    void searchRepo() {
        Repo repo3 = new Repo("my_repo3", "some_description");

        int countRepoBeforeCreate = repoSteps.searchRepo(repo3);
        assertEquals(0, countRepoBeforeCreate);

        repoSteps.createRepo(repo3);
        Selenide.sleep(2000);

        int countRepoAfterCreate = repoSteps.searchRepo(repo3);
        assertEquals(1, countRepoAfterCreate);

        repoSteps.deleteRepo(repo3);
    }

    @Test
    @DisplayName("Создание Issue")
    void createdIssue() {
        Repo repo4 = new Repo("my_repo4", "some_description");
        Issue issue1 = new Issue("My issue 1", "my_body_1", null, new String[]{"a", "b", "c"}, new String[]{USER});

        repoSteps.createRepo(repo4);
        issueSteps.createIssue(repo4, issue1)
                .checkExistsIssue(repo4, issue1);
        repoSteps.deleteRepo(repo4);
    }

    @Test
    @DisplayName("Редактирование Issue")
    void editedIssue() {
        Repo repo5 = new Repo("my_repo5", "some_description");
        Issue issue2 = new Issue("My issue 2", "my_body_1", null, new String[]{"a", "b", "c"}, new String[]{USER});
        Issue newIssue = new Issue("My issue edited", "my_body_1", null, new String[]{"a", "b", "c"}, new String[]{USER});

        repoSteps.createRepo(repo5);
        issueSteps.createIssue(repo5, issue2)
                .editNameIssue(repo5, issue2, newIssue);
        repoSteps.deleteRepo(repo5);
    }

    @Test
    @DisplayName("Блокировка Issue")
    void blockedIssue() {
        Repo repo6 = new Repo("my_repo6", "some_description");
        Issue issue3 = new Issue("My issue 3", "my_body_1", null, new String[]{"a", "b", "c"}, new String[]{USER});

        repoSteps.createRepo(repo6);
        issueSteps.createIssue(repo6, issue3)
                .lockIssue(repo6);
        repoSteps.deleteRepo(repo6);
    }
}
