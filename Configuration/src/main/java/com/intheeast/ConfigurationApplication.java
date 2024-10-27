package com.intheeast;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.intheeast.demo.h2.entity.Person;
import com.intheeast.demo.h2.repository.PersonRepository;
import com.intheeast.demo.mysql.entity.User;
import com.intheeast.demo.mysql.repository.UserRepository;


@SpringBootApplication
public class ConfigurationApplication {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(PersonRepository repository) {
		
		return args -> {
			Person person = new Person();
			person.setName("John");

			repository.save(person);
			Person saved = repository.
					findById(person.getId()).
					orElseThrow(NoSuchElementException::new);
	    };
	}
	
	@Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            // User 객체를 생성하여 데이터베이스에 저장
            User user1 = new User();
            user1.setFirstname("John");
            user1.setLastname("Doe");
            user1.setEmail("swseokitec@gmail.com");

            User user2 = new User();
            user2.setFirstname("Jane");
            user2.setLastname("Doe");
            user2.setEmail("intheeast0305@gmail.com");

            // User 객체를 데이터베이스에 삽입
            userRepository.saveAll(Arrays.asList(user1, user2));
            System.out.println("Users have been inserted.");
        };
    }

}
