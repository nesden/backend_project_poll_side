package com.example.poll_project_question_backend.controller;

import com.example.poll_project_question_backend.user.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserClient userClient;

    @GetMapping("/{userId}")
    public String getUserById(@PathVariable int userId) {
        return userClient.getUserById(userId);
    }
}
