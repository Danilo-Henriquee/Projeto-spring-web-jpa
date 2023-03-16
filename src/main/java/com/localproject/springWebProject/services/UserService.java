package com.localproject.springWebProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localproject.springWebProject.entities.User;
import com.localproject.springWebProject.repositories.UserRepository;
import com.localproject.springWebProject.services.exceptions.ResourceNotFoundException;

/*
 * @Component está dizendo ao Spring que essa classe agora é um
 * componente spring e ele vai pode ser injetado com @Autowired
 * que é a injeção de dependencia do Spring não explicita
 * 
 * @Service faz a mesma coisa que o @Component porém está deixando
 * explicito que essa classe é um serviço o que nesse ocasião
 * cabe semanticamente melhor do que @Component
 */
//@Component
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		/*
		 * A operação findById vai retornar um objeto optional 
		 * do tipo user
		 */
		Optional<User> obj = repository.findById(id);
//		A operação get do optional ela vai retornar um objeto do tipo
//		inserido no generic que no caso é o User que estiver dentro 
//		do optional
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
