package com.example.poll_project_question_backend.repository.mapper;

import com.example.poll_project_question_backend.model.CountAnswer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountAnswerMapper implements RowMapper<CountAnswer> {
    @Override
    public CountAnswer mapRow(ResultSet rs, int rowNum) throws SQLException {
        int answerId = rs.getInt("answer_id");
        int answerCount = rs.getInt("answer_count");
        return new CountAnswer(answerId, answerCount);
    }
}
