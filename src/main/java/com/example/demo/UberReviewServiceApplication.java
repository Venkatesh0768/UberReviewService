package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.example.demo",
		"org.example.uberprojectentityservice" // shared JAR
})
@EntityScan(basePackages = {
		"org.example.uberprojectentityservice.models", // shared entities
		"com.example.uberreviewservice.models"         // local models
})
@EnableJpaRepositories(basePackages = {
		"com.example.demo.repositories"
})
public class UberReviewServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UberReviewServiceApplication.class, args);
	}

}
