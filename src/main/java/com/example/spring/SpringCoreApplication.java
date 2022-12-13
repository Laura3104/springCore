package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.spring.repository")
public class SpringCoreApplication {
	public static void main(String[] args) {
		//SpringApplication.run(SpringCoreApplication.class, args);
		try {
			SpringApplication.run(SpringCoreApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
