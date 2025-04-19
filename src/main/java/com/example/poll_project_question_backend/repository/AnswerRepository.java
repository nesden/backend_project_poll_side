package com.example.poll_project_question_backend.repository;
import com.example.poll_project_question_backend.model.Answer;
import com.example.poll_project_question_backend.repository.mapper.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AnswerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Answer save(Answer answer) {
        try {
            String sql = "INSERT INTO answer (question_id, answer_id, user_id) VALUES(?,?,?)";
            jdbcTemplate.update(sql, answer.getQuestionId(), answer.getAnswerId(), answer.getUserId());
            return getAnswerByQuestionIdAndUserIdHelper(answer.getQuestionId(), answer.getUserId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Answer update(Answer answer) {
        try {
            String sql = "UPDATE answer SET answer_id= ? WHERE id= ?";
            //all you switch in an updated answer is which answer you choose .no need to change user id or question id
            jdbcTemplate.update(sql, answer.getAnswerId(), answer.getId());
            return getById(answer.getId());
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
            List<Answer> answers = jdbcTemplate.query(sql, new AnswerMapper(), id);
            return answers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public List<Map<String, Object>> getAnswerCount(Integer id) {
        try {
            String sql = "SELECT answer_id AS answer_number, COUNT(*) AS amount FROM answer WHERE question_id  = ? GROUP BY answer_id";
            return jdbcTemplate.queryForList(sql, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Map<String, Object> getAnswerCountPerUserByQuestId(int id) {
        try {
            String sql = "SELECT COUNT(user_id) as users FROM answer WHERE question_id =? ";
            return jdbcTemplate.queryForMap(sql, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Map<String, List<Map<String, Object>>> getAllQuestionsAndAnswerCount() {
        try {

            String sqlHelper = "SELECT id AS question_number FROM question";
            Map<String, List<Map<String, Object>>> outerMap = new LinkedHashMap<>();

            List<Integer> questionIdList = jdbcTemplate.queryForList(sqlHelper, Integer.class);


            for (Integer questionId : questionIdList) {

                String sqlAnswers = "SELECT answer_id AS answer_number, COUNT(*) AS amount FROM answer WHERE question_id=? GROUP BY answer_id";

                List<Map<String, Object>> answerCounts = jdbcTemplate.queryForList(sqlAnswers, questionId);
                outerMap.put("question " + questionId, answerCounts);
            }
            return outerMap;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public String deleteAllAnswersByUserId(int id) {
        try {
            String sql = "DELETE FROM answer WHERE user_id= ?";
            jdbcTemplate.update(sql, id);
            return "the answers made by user " + id + " deleted successfully";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public Answer getAnswerByQuestionIdAndUserIdHelper(int questionId, int userId) {
        try {
            String sql = "SELECT * FROM answer WHERE question_id = ? AND user_id=?";
            return jdbcTemplate.queryForObject(sql, new AnswerMapper(), questionId, userId);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}


