package com.johanna.studyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyappApplication.class, args);
	}

}
