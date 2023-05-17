package com.microservice.movieratingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRatingServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingServiceApplication.class, args);
	}

	public void run(String...args) throws Exception {
		System.out.println("movie rating service is running");
	}

}
