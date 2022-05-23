package tests.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repo {
    public String name;
    public String description;


    public String getName() {
        return name;
    }

    public Repo(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public Repo() {
    }
}