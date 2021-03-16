package com.cursojava.aulawebservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.aulawebservices.entities.User;
import com.cursojava.aulawebservices.repositories.UserRepository;

//Camada SERVICE

//registrar a classe  OrderService como COMPONENT
/* Quando um objeto vai ser “injetado”  pelo mecanismo de injeção de dependência do Spring, 
  a CLASSE DESTE OBJETO DEVE SER REGISTRADA no mecanismo de injeção de dependência.
  Ver OrderResource fazendo injecao de OrderService:
  @Autowired
  private OrderService service;
*/
@Service
public class UserService {

	//Injeção de dependência do framework Spring
	//Associa UserRepository a UserService
	@Autowired
	private UserRepository repository;

	// Camada servico faz chamada camada repository
	public List<User>  findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id){
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		// getOne instancia o User mas nao vai no Banco Dados. Deixa o objeto monitorado
		// pelo JPA.
		// O findById vai no Banco de Dados e recupera o objeto.
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
