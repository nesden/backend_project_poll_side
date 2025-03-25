package com.example.poll_project_question_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

//    @GetMapping("/data")
//    public String getData(){
//        return "data from question?";
//    }
    @GetMapping("/data")
    public ResponseEntity<String> getData(){
        return ResponseEntity.ok(" data from service a");
    }
}
