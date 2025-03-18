package com.example.poll_project_question_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
    private int id;
    @JsonProperty(value = "question_title")
    private String questionTitle;
    @JsonProperty(value = "answer_1")
    private String answer1;
    @JsonProperty(value = "answer_2")
    private String answer2;
    @JsonProperty(value = "answer_3")
    private String answer3;
    @JsonProperty(value = "answer_4")
    private String answer4;

    public Question(int id, String questionTitle, String answer1, String answer2, String answer3, String answer4) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionTitle='" + questionTitle + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
                '}';
    }
}
