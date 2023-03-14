package com.localproject.springWebProject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.localproject.springWebProject.entities.User;
import com.localproject.springWebProject.services.UserService;

/*
 * Para dizer que essa classe UserResource é um recurso web que é
 * implementado por um controlador rest usa essa anotação
 * @RestController
 * 
 * @RestController vai retornar o objeto e os dados desse objeto
 * no formato JSON para consumo
 * 
 * Além disso é preciso dar um nome para o recurso e nessa anotação vai ser
 * inserido o caminho do recurso e como é um recurso relacionado a entidade user
 * então vai ser chamado de "/users"
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	/*
	 * Esse método vai ser o end-point para acessar os dados, primeiro vai retornar
	 * um ResponseEntity que é um tipo especifico do Spring para retornar respostas
	 * de requisições web, esse ResponseEntity ele é um generics ele espera um tipo
	 * e o tipo dessa resposta vai ser a classe User, então vai ser retornado um
	 * recurso do tipo User no formato JSON
	 */
	
	/* 
	 * Para indicar que esse método findAll() vai ser um método
	 * que responde a requisição do tipo get do http utiliza-se 
	 * o método @GetMapping
	 * o GET no HTTP ele é responsavel por receber dados de um resource 
	 * que no caso o resource é a entidade User
	 */
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		/*
		 * Aqui o responseEntity esta utilizando o método ok() 
		 * para retornar a response com sucesso no http e utiliza o 
		 * .body() para retornar o corpo da resposta e passando
		 * como parametro o u que é o usuario criado 
		 */
		return ResponseEntity.ok().body(list);
	}
	
	/*
	 * Para dizer que esse método é o método Get da requisição HTTP 
	 * usa o @GetMapping
	 * O id dentro das chaves indica que a requisição vai aceitar
	 * um Id dentro da URL
	 * @PathVariable vai fazer com que o Spring aceite esse Id e vai
	 * considera-lo como parametro que vai chegar na URL
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
