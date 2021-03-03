package com.cursojava.aulawebservices.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.aulawebservices.entities.User;
import com.cursojava.aulawebservices.repositories.UserRepository;

//Aula310 - Configuration class for "test" profile

@Configuration
// mesmo param. spring.profiles.active=test do arq. "application.properties" 
// Spring identifica que vai rodar esta configuracao, somente quando perfil test
@Profile("test")
// interface CommandLineRunner - Para executar quando programa for iniciado 
public class TestConfig implements CommandLineRunner{

//Aula310 - Injeção de dependência do framework Spring
//Associa UserRepository a TestConfig
	@Autowired
	private UserRepository userRepository;

// interface CommandLineRunner - Para executar quando programa for iniciado
@Override
public void run(String... args) throws Exception {
	User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
	User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
	userRepository.saveAll(Arrays.asList(u1, u2));
	}   
}
