package com.microservice.moviecatelogservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatelogServiceApplication implements CommandLineRunner {

	// if i am going to use restTemplate, rather than initializing RestTemplate on each file, better if
	// i initialize it here, so that i can autowire and use whereever i call any external API using RestTemplate
	// @Bean helps me to create the object when the application runs
	// @Bean are by defualt singlton
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatelogServiceApplication.class, args);
	}

	public void run(String...args) throws Exception {
		System.out.println("Movie catalog service is running right");
	}

}
