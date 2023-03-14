package com.localproject.springWebProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.localproject.springWebProject.entities.User;

/* 
 * Essa interface ja possui todas as operações SQL especificas
 * para a entidade User.
 * Para utiliza-la ela herda da classe JpaRepository passando nos
 * seus generics qual vai ser o tipo de que as operações SQL irão
 * fazer, que no caso é o User, e no segundo generic, é o tipo da
 * chave primaria que deve ser igual ao da entidade User
 */
public interface UserRepository extends JpaRepository<User, Long>{
	
}
