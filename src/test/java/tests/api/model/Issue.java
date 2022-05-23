package tests.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {
    public String title;
    public String body;
    public String milestone;
    public boolean locked;
    public String[] labels;
    public String[] assignees;

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public boolean isLocked() {
        return locked;
    }

    public Issue(String title, String body, String milestone, boolean locked, String[] labels, String[] assignees) {
        this.title = title;
        this.body = body;
        this.milestone = milestone;
        this.locked = locked;
        this.labels = labels;
        this.assignees = assignees;
    }

    public Issue(String title, String body, String milestone, String[] labels, String[] assignees) {
        this(title, body, milestone, false, labels, assignees);
    }

    public Issue(String title, String body, String milestone) {
        this(title, body, null, new String[]{"a", "b", "c"}, new String[]{"autotest-nk"});
    }

    public Issue(String title, String body) {
        this(title, body, null, new String[]{"a", "b", "c"}, new String[]{"autotest-nk"});
    }

    public Issue(boolean locked) {
        this.locked = locked;
    }

    public Issue() {

    }
}