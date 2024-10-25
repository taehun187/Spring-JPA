package com.taehun.demo;

import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.taehun.demo.entity.User;
import com.taehun.demo.repository.UserRepository;

@SpringBootApplication
public class GettingStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(GettingStartApplication.class, args);
	
	}

	@Bean
	CommandLineRunner runner(UserRepository repository) {
		
		return args -> {
			User user = new User();
			user.setName("Taehun");
			user.setLastname("Lee");
			user.setEmail("lth1518@gmail.com");
			
			repository.save(user);
			User saved = repository.
					findById(user.getId()).
					orElseThrow(NoSuchElementException::new);
		};
	}
}
