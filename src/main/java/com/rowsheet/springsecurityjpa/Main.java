package com.rowsheet.springsecurityjpa;

import com.rowsheet.springsecurityjpa.models.CommentRepository;
import com.rowsheet.springsecurityjpa.models.PostRepository;
import com.rowsheet.springsecurityjpa.models.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {
		UserRepository.class,
		PostRepository.class,
		CommentRepository.class,
})
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
