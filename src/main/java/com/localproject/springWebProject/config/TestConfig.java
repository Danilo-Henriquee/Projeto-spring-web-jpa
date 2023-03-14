package com.localproject.springWebProject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.localproject.springWebProject.entities.Order;
import com.localproject.springWebProject.entities.User;
import com.localproject.springWebProject.repositories.OrderRepository;
import com.localproject.springWebProject.repositories.UserRepository;

/*
 * @Configuration vai dizer para o spring que essa classe vai ser uma
 * classe de configuração
 * @Profile vai dizer que essa classe vai ser uma configuração
 * especifica para o perfil de test entre os parenteses se insere
 * o nome que foi colocado no application-test.properties.
 * O spring consegue identificar que ele só vai rodar essa 
 * configuração somente quando estiver no perfil de test
 * 
 * A implementação CommandLineRunner que vai dizer que quando a 
 * aplicação for executada os códigos dessa classe também vão ser
 * executados dentro do método run
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

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		o Id está nulo porque o Id sera gerado automaticamente
//		pelo banco de dados
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1); 
		
//		Essa operação saveAll ela irá inserir os dados contidos nela
//		a partir de um iteravel como uma lista, e cada iteração vai
//		ser adicionada ao banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
}
