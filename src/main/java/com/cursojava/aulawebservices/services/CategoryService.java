package com.cursojava.aulawebservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.aulawebservices.entities.Category;
import com.cursojava.aulawebservices.repositories.CategoryRepository;

//Camada SERVICE

//registrar a classe  CategoryService como COMPONENT
/* Quando um objeto vai ser “injetado”  pelo mecanismo de injeção de dependência do Spring, 
  a CLASSE DESTE OBJETO DEVE SER REGISTRADA no mecanismo de injeção de dependência.
  Ver CategoryResource fazendo injecao de CategoryService:
  @Autowired
  private CategoryService service;
*/
@Service
public class CategoryService {

	//Injeção de dependência do framework Spring
	//Associa CategoryRepository a CategoryService
	@Autowired
	private CategoryRepository repository;

	// Camada servico faz chamada camada repository
	public List<Category>  findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id){
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
