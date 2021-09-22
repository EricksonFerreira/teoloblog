package com.example.teoloblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TeoloblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeoloblogApplication.class, args);
	}

}
