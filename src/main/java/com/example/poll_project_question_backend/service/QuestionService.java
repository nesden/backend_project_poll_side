package com.example.poll_project_question_backend.service;


import com.example.poll_project_question_backend.model.Question;
import com.example.poll_project_question_backend.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question save(Question question) {
        if (question.getQuestionTitle().trim().isEmpty() || question.getAnswer1().trim().isEmpty() || question.getAnswer2().trim().isEmpty() || question.getAnswer3().trim().isEmpty() || question.getAnswer4().trim().isEmpty()) {
            return null;
        }
        return questionRepository.save(question);
    }

    public Question update(Question question) {
        if (question.getQuestionTitle().trim().isEmpty() || question.getAnswer1().trim().isEmpty() || question.getAnswer2().trim().isEmpty() || question.getAnswer3().trim().isEmpty() || question.getAnswer4().trim().isEmpty()) {
            return null;
        }
        return questionRepository.update(question);
    }


    public String deleteById(int id) {
        if (questionRepository.getById(id) != null) {
            return questionRepository.deleteById(id);
        }
        return "the question with id " + id + " doesnt exist so it cant be deleted";
    }

    public Question getById(int id) {
        return questionRepository.getById(id);
    }

}
