package com.cursojava.aulawebservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.aulawebservices.entities.User;
import com.cursojava.aulawebservices.repositories.UserRepository;

//Aula311 - Camada SERVICE

//Aula311 - registrar a classe  UserService como COMPONENT
/* Quando um objeto vai ser “injetado”  pelo mecanismo de injeção de dependência do Spring, 
  a CLASSE DESTE OBJETO DEVE SER REGISTRADA no mecanismo de injeção de dependência.
  Ver UserResource fazendo injecao de UserService:
  @Autowired
  private UserService service;
*/
@Service
public class UserService {

	//Aula311 - Injeção de dependência do framework Spring
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
	
}
