package com.example.poll_project_question_backend.repository.mapper;

import com.example.poll_project_question_backend.model.Answer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AnswerMapper implements RowMapper<Answer> {
    @Override
    public Answer mapRow(ResultSet rs,int rowNum) throws SQLException{
        Answer answer=new Answer();
        answer.setId((rs.getInt("id")));
        answer.setAnswerId(rs.getInt("answer_id"));
        answer.setQuestionId(rs.getInt("question_id"));
        answer.setUserId(rs.getInt("user_id"));
        return answer;
    }

}
