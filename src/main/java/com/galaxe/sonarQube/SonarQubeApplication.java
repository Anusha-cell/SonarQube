package com.galaxe.sonarQube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SonarQubeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SonarQubeApplication.class, args);
	}

	System.out.println("For testing purpose");
}
