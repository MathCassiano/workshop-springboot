package com.matheuscassiano.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matheuscassiano.course.entities.User;
import com.matheuscassiano.course.repositories.UserRepository;

@Configuration
//dizer que é uma configuração especifica do perfil de teste
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	//injeção de dependencia
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
