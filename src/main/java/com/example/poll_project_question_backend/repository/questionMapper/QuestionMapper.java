package com.example.poll_project_question_backend.repository.questionMapper;

import com.example.poll_project_question_backend.model.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class QuestionMapper implements RowMapper<Question> {

    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();
        question.setId(rs.getInt("id"));
        question.setQuestionTitle(rs.getString("question_title"));
        question.setAnswer1(rs.getString("answer_1"));
        question.setAnswer2(rs.getString("answer_2"));
        question.setAnswer3(rs.getString("answer_3"));
        question.setAnswer4(rs.getString("answer_4"));
        return question;
    }
}
