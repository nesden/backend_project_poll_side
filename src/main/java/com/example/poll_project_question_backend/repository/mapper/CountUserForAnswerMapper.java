package com.example.poll_project_question_backend.repository.mapper;

import com.example.poll_project_question_backend.model.CountUserForAnswer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountUserForAnswerMapper implements RowMapper<CountUserForAnswer> {

    @Override
    public CountUserForAnswer mapRow(ResultSet rs, int rowNum) throws SQLException {
        CountUserForAnswer countUserForAnswer=new CountUserForAnswer();
        countUserForAnswer.setId(rs.getInt("id"));
        countUserForAnswer.setUserCount(rs.getInt("user_count"));
        return countUserForAnswer;
    }
}
