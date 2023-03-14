package com.localproject.springWebProject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.localproject.springWebProject.entities.User;
import com.localproject.springWebProject.repositories.UserRepository;

/*
 * @Configuration vai dizer para o spring que essa classe vai ser uma
 * classe de configuração
 * @Profile vai dizer que essa classe vai ser uma configuração
 * especifica para o perfil de test entre os parenteses se insere
 * o nome que foi colocado no application-test.properties.
 * O spring consegue identificar que ele só vai rodar essa 
 * configuração somente quando estiver no perfil de test
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	/*
	 * @Autowired faz com que o spring consiga resolver essa 
	 * dependencia e associar uma instancia do userRepository 
	 * ao TestConfig
	 */
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}
