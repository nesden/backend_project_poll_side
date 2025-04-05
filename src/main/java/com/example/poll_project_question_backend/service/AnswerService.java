package com.example.poll_project_question_backend.service;

import com.example.poll_project_question_backend.model.Answer;

import com.example.poll_project_question_backend.model.CountAnswer;
import com.example.poll_project_question_backend.model.CountUserForAnswer;
import com.example.poll_project_question_backend.repository.AnswerRepository;
import com.example.poll_project_question_backend.user.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class AnswerService {


    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private UserClient userClient;

    public Answer save(Answer answer) {
        if (userClient.getUserById(answer.getUserId()) != null) {// calls the user by the id
            return answerRepository.save(answer);
        }
        return null;
    }

    public Answer update(Answer answer) {
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



//    public List<CountAnswer> getAnswerCount(int id) {
//        return answerRepository.getAnswerCount(id);
//    }
    public List<Map<String, Object>> getAnswerCount(Integer id) {
        return answerRepository.getAnswerCount(id);
    }
//    public CountUserForAnswer getAnswerCountPerUserByQuestId(int id) {
//        return answerRepository.getAnswerCountPerUserByQuestId(id);
//    }
    public  Map<String,Object> getAnswerCountPerUserByQuestId(int id) {
        return answerRepository.getAnswerCountPerUserByQuestId(id);
    }



    public String deleteAllAnswersByUserId(int id) {
        if (userClient.getUserById(id) != null) {
            return answerRepository.deleteAllAnswersByUserId(id);
        } else
            return null;
    }
}


