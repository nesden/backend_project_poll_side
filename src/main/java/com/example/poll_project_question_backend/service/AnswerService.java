package com.example.poll_project_question_backend.service;

import com.example.poll_project_question_backend.model.Answer;
import com.example.poll_project_question_backend.repository.AnswerRepository;
import com.example.poll_project_question_backend.user.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
//            if (answerRepository.getAllAnswersByUserId(id).isEmpty()) {
//                return null;
//            }
            return answerRepository.getAllAnswersByUserId(id);
        } else
            return null;
    }


//    public ResponseEntity<List<Answer>> getAllByUserId(int id) {
//        if (userClient.getUserById(id) != null) {
//            if (answerRepository.getAllAnswersByUserId(id).equals("[]")) {
//                return new ResponseEntity("the user with id " + id + " has no answers", HttpStatus.BAD_REQUEST);
//            }
//            return new ResponseEntity(answerRepository.getAllAnswersByUserId(id), HttpStatus.OK);
//        } else
//            return null;
//    }
//    public ResponseEntity<List<Answer>> getAllByUserId(int id) {
//        if (userClient.getUserById(id) != null) {
//            if (answerRepository.getAllAnswersByUserId(id).equals("[]")) {
//                return new ResponseEntity("the user with id " + id + " has no answers", HttpStatus.BAD_REQUEST);
//            }
//            return new ResponseEntity(answerRepository.getAllAnswersByUserId(id), HttpStatus.OK);
//        } else
//            return null;
//    }
}
