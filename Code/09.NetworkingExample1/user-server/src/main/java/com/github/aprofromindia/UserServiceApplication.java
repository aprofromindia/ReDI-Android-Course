package com.github.aprofromindia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner saveUsers(){
		return args -> {
			repository.save(new User("Apro", 25, "Android"));
			repository.save(new User("Tom", 26, "English"));
			repository.save(new User("John", 27, "Bengali"));
		};
	}
}
