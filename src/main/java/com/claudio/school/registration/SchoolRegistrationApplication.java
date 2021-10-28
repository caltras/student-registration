package com.claudio.school.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.claudio.school.registration.repository") 
public class SchoolRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolRegistrationApplication.class, args);
	}

}
