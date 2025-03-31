package com.example.poll_project_question_backend.controller;

import com.example.poll_project_question_backend.model.User;
import com.example.poll_project_question_backend.user.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/re-user")
public class UserController {
    @Autowired
    private UserClient userClient;

    public UserController(UserClient userClient) {
        this.userClient = userClient;
    }

    public UserController() {
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        try{
            return userClient.getUserById(userId);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
