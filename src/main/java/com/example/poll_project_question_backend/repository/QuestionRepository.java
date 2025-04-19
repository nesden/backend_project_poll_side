package com.example.poll_project_question_backend.repository;


import com.example.poll_project_question_backend.model.Question;
import com.example.poll_project_question_backend.repository.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class QuestionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Question save(Question question) {
        try {
            String sql = "INSERT INTO question (question_title,answer_1, answer_2, answer_3,answer_4) VALUES(?,?,?,?,?)";
            jdbcTemplate.update(sql, question.getQuestionTitle(), question.getAnswer1(), question.getAnswer2(), question.getAnswer3(), question.getAnswer4());
            System.out.println(question.getQuestionTitle() + question.getAnswer1() + question.getAnswer2() + question.getAnswer3() + question.getAnswer4());
            return getByQuestionTitleHelper(question.getQuestionTitle());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Question update(Question question) {
        try {
            String sql = "UPDATE question SET question_title=? ,answer_1=?, answer_2=?, answer_3=?,answer_4=? WHERE id= ?";
            jdbcTemplate.update(sql, question.getQuestionTitle(), question.getAnswer1(), question.getAnswer2(), question.getAnswer3(), question.getAnswer4(), question.getId());
            return getById(question.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteById(int id) {
        try {
            String sql = "DELETE FROM question WHERE id= ?";
            jdbcTemplate.update(sql, id);
            return "the question with id " + id + " deleted successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Question getById(int id) {
        try {
            String sql = "SELECT * FROM question WHERE id=?";

            return jdbcTemplate.queryForObject(sql, new QuestionMapper(), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }




    public Question getByQuestionTitleHelper(String title) {
        try {
            String sql = "SELECT * FROM question WHERE question_title = ?";
            return jdbcTemplate.queryForObject(sql, new QuestionMapper(), title);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }


    }

}
