package com.example.poll_project_question_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountUserForAnswer {
    private int id;
    @JsonProperty(value = "user_count")
    private int userCount;

    public CountUserForAnswer(int id, int userCount) {
        this.id = id;
        this.userCount = userCount;
    }

    public CountUserForAnswer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

}
