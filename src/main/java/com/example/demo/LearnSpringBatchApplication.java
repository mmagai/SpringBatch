package com.example.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableBatchProcessing
@ComponentScan("com.example.config")
public class LearnSpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBatchApplication.class, args);
	}

}
