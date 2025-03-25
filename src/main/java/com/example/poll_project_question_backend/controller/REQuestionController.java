package com.example.poll_project_question_backend.controller;



import com.example.poll_project_question_backend.model.Question;
import com.example.poll_project_question_backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/re-question")
public class REQuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
        try {
            Question savedQuestion=questionService.save(question);
            if (savedQuestion!=null){
                return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping
    public ResponseEntity<Question> update(@RequestBody Question question) {
        try {
            Question updatedQuestion = questionService.update(question);
            if (updatedQuestion != null) {
                return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
        try {
            String result = questionService.deleteById(id);
            if (result.contains("successfully")) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable int id) {

        try {
            Question question = questionService.getById(id);
            if (question != null) {
                return new ResponseEntity<>(question, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
