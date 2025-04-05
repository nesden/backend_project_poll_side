package com.example.poll_project_question_backend.model;

public class CountAnswer {
    private int answerId;
    private int answerCount;

    public CountAnswer(int answerId, int answerCount) {
        this.answerId = answerId;
        this.answerCount = answerCount;
    }

    public CountAnswer() {
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }
}
