package com.example.restInn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RestInnApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestInnApplication.class, args);
	}

	@Bean
	public org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
