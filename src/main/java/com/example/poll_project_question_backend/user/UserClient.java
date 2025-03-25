package com.example.poll_project_question_backend.user;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="${external-api.user.name}",url="${external-api.user.url}")
public interface UserClient {
    @GetMapping("/re-user/{userId}")
    String getUserById(@PathVariable int userId);
}
