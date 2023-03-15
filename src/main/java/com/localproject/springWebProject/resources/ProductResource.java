package com.localproject.springWebProject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.localproject.springWebProject.entities.Product;
import com.localproject.springWebProject.services.ProductService;

/*
 * Para dizer que essa classe ProductResource é um recurso web que é
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
@RequestMapping(value = "/products")
public class ProductResource {

	/*
	 * Esse método vai ser o end-point para acessar os dados, primeiro vai retornar
	 * um ResponseEntity que é um tipo especifico do Spring para retornar respostas
	 * de requisições web, esse ResponseEntity ele é um generics ele espera um tipo
	 * e o tipo dessa resposta vai ser a classe Product, então vai ser retornado um
	 * recurso do tipo Product no formato JSON
	 */
	
	/* 
	 * Para indicar que esse método findAll() vai ser um método
	 * que responde a requisição do tipo get do http utiliza-se 
	 * o método @GetMapping
	 * o GET no HTTP ele é responsavel por receber dados de um resource 
	 * que no caso o resource é a entidade Product
	 */
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
