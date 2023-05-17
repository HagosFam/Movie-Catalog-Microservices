package com.microservice.moviecatelogservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieCatelogServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatelogServiceApplication.class, args);
	}

	public void run(String...args) throws Exception {
		System.out.println("Service first is running");
	}

}
