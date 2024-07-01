package com.example.authority_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class AuthorityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorityServiceApplication.class, args);
	}

}
