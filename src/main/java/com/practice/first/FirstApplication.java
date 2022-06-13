package com.practice.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.practice")
@EntityScan(basePackages = "com.practice.model")
@EnableJpaRepositories("com.practice.repository")
public class FirstApplication {

	public static void main(String[] args) {	
		SpringApplication.run(FirstApplication.class, args);
	}

}
