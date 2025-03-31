package com.example.poll_project_question_backend.repository;

import com.example.poll_project_question_backend.model.Answer;
import com.example.poll_project_question_backend.model.Question;
import com.example.poll_project_question_backend.repository.mapper.AnswerMapper;
import com.example.poll_project_question_backend.repository.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Answer save(Answer answer) {
        try {
            String sql = "INSERT INTO answer (question_id, answer_id, user_id) VALUES(?,?,?)";
            jdbcTemplate.update(sql, answer.getQuestionId(), answer.getAnswerId(), answer.getUserId());
            return answer;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Answer update(Answer answer) {
        try {
            String sql = "UPDATE answer SET question_id= ?, answer_id= ?, user_id= ? WHERE id= ?";
            jdbcTemplate.update(sql, answer.getQuestionId(), answer.getAnswerId(), answer.getUserId(), answer.getId());
            return answer;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteById(int id) {
        try {
            String sql = "DELETE FROM answer WHERE id= ?";
            jdbcTemplate.update(sql, id);
            return "the answer with id " + id + " deleted successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Answer getById(int id) {
        try {
            String sql = "SELECT * FROM answer WHERE id=?";
            return jdbcTemplate.queryForObject(sql, new AnswerMapper(), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public List<Answer> getAllAnswersByUserId(int id) {
        try {
            String sql = "SELECT * FROM answer WHERE user_id=?";
            List<Answer> answers=jdbcTemplate.query(sql,new AnswerMapper(),id);
            return answers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
//    public String deleteAllAnswersByUserId(int id){
//
//    }
}


