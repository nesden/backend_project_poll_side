package com.example.poll_project_question_backend.service;

import com.example.poll_project_question_backend.model.Answer;

import com.example.poll_project_question_backend.repository.AnswerRepository;
import com.example.poll_project_question_backend.user.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AnswerService {


    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private UserClient userClient;

    public Answer save(Answer answer) {

        System.out.println(answer.getAnswerId());
        if (answer.getAnswerId() > 4 || answer.getAnswerId() < 1) {
            System.out.println("this");
            return null;
        }
        System.out.println(answer.getAnswerId());
        if (userClient.getUserById(answer.getUserId()) == null) {// calls the user by the id
            return null;
        }
        return answerRepository.save(answer);

    }

    public Answer update(Answer answer) {
        if (answer.getAnswerId() > 4 || answer.getAnswerId() < 1) {
            return null;
        }
        return answerRepository.update(answer);
    }

    public String deleteById(int id) {
        if (answerRepository.getById(id) != null) {
            return answerRepository.deleteById(id);
        }
        return "the answer with id " + id + " doesnt exist so it cant be deleted";
    }

    public Answer getById(int id) {
        return answerRepository.getById(id);

    }

    public List<Answer> getAllByUserId(int id) {
        if (userClient.getUserById(id) != null) {
            return answerRepository.getAllAnswersByUserId(id);
        } else
            return null;
    }

    public List<Map<String, Object>> getAnswerCount(Integer id) {
        return answerRepository.getAnswerCount(id);
    }

    public Map<String, Object> getAnswerCountPerUserByQuestId(int id) {
        return answerRepository.getAnswerCountPerUserByQuestId(id);
    }

    public Map<String, List<Map<String, Object>>> getAllQuestionsAndAnswerCount() {
        return answerRepository.getAllQuestionsAndAnswerCount();
    }

    public String deleteAllAnswersByUserId(int id) {
        if (userClient.getUserById(id) != null) {
            return answerRepository.deleteAllAnswersByUserId(id);
        } else
            return null;
    }
}


