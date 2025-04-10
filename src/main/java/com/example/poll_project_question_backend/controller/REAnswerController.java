package com.example.poll_project_question_backend.controller;


import com.example.poll_project_question_backend.model.Answer;
import com.example.poll_project_question_backend.model.CountAnswer;
import com.example.poll_project_question_backend.model.CountUserForAnswer;
import com.example.poll_project_question_backend.service.AnswerService;
import com.example.poll_project_question_backend.user.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/re-answer")
public class REAnswerController {
    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserClient userClient;

    @PostMapping
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {
        try {

            Answer savedAnswer = answerService.save(answer);
            if (savedAnswer != null) {
                return new ResponseEntity<>(savedAnswer, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping
    public ResponseEntity<Answer> update(@RequestBody Answer answer) {
        try {
            Answer updatedAnswer = answerService.update(answer);
            if (updatedAnswer != null) {
                return new ResponseEntity<>(updatedAnswer, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable int id) {
        try {
            String result = answerService.deleteById(id);
            if (result.contains("successfully")) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswer(@PathVariable int id) {

        try {
            Answer answer = answerService.getById(id);
            if (answer != null) {
                return new ResponseEntity<>(answer, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all-answers/{id}")
    public ResponseEntity<List<Answer>> getAllAnswersByUserId(@PathVariable int id) {
        try {

            return new ResponseEntity(answerService.getAllByUserId(id), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/count-user-answers/{id}")
    public ResponseEntity<String> getUserAnswerCount(@PathVariable int id) {
        try {
            int count;
            count = answerService.getAllByUserId(id).toArray().length;
            String result = " the user with id " + id + " has answered " + count + " questions";
            return new ResponseEntity(result, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    @GetMapping("/count-answers/{id}")
//    public ResponseEntity<CountAnswer> getAnswerCount(@PathVariable int id){
//        try {
//            return new ResponseEntity(answerService.getAnswerCount(id),HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    @GetMapping("/count-answers/{id}")
    public ResponseEntity<List<Map<String, Object>>> getAnswerCount(@PathVariable Integer id) {
        try {
            return new ResponseEntity(answerService.getAnswerCount(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //
//    @GetMapping("/count-answers-per-user/{id}")
//    public ResponseEntity<CountUserForAnswer> getAnswerCountPerUserByQuestId(@PathVariable int id) {
//        try {
//            return new ResponseEntity(answerService.getAnswerCountPerUserByQuestId(id), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    @GetMapping("/count-answers-per-user/{id}")
    public ResponseEntity<Map<String, Object>> getAnswerCountPerUserByQuestId(@PathVariable int id) {
        try {
            return new ResponseEntity(answerService.getAnswerCountPerUserByQuestId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-questions-and-answers")
    public ResponseEntity<Map<String, List<Map<String, Object>>>> getAllQuestionsAndAnswerCount() {//List<String>
        try {
            return new ResponseEntity(answerService.getAllQuestionsAndAnswerCount(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //change this url to something else
    @DeleteMapping("/questions-by-user/{userId}")
    public ResponseEntity<String> deleteAnswersByUserId(@PathVariable int userId) {
        try {
            String result = answerService.deleteAllAnswersByUserId(userId);
            if (result.contains("successfully")) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
