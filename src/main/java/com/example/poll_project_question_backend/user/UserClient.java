package com.example.poll_project_question_backend.user;


import com.example.poll_project_question_backend.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="${external-api.user.name}",url="${external-api.user.url}")
public interface UserClient {
    @GetMapping("/re-user/{userId}")
    ResponseEntity<User> getUserById(@PathVariable int userId);
}
