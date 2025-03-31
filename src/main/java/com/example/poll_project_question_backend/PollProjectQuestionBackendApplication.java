package com.example.poll_project_question_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PollProjectQuestionBackendApplication {//make sure the get all by user id will give nothing if its empty

	public static void main(String[] args) {
		SpringApplication.run(PollProjectQuestionBackendApplication.class, args);
	}

}
