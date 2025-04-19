package com.example.poll_project_question_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {
    private int id;
    @JsonProperty("question_id")
    private int questionId;
    @JsonProperty("answer_id")
    private int answerId;
    @JsonProperty("user_id")
    private int userId;

    public Answer(int id, int questionId, int answerId, int userId) {
        this.id = id;
        this.questionId = questionId;
        this.answerId = answerId;
        this.userId = userId;
    }

    public Answer() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", answerId=" + answerId +
                ", userId=" + userId +
                '}';
    }
}
