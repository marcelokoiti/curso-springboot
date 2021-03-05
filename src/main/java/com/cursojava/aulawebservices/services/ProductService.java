package com.cursojava.aulawebservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.aulawebservices.entities.Product;
import com.cursojava.aulawebservices.repositories.ProductRepository;

//Camada SERVICE

//registrar a classe  OrderService como COMPONENT
/* Quando um objeto vai ser “injetado”  pelo mecanismo de injeção de dependência do Spring, 
  a CLASSE DESTE OBJETO DEVE SER REGISTRADA no mecanismo de injeção de dependência.
  Ver OrderResource fazendo injecao de OrderService:
  @Autowired
  private OrderService service;
*/
@Service
public class ProductService {

	//Injeção de dependência do framework Spring
	//Associa ProductRepository a ProductService
	@Autowired
	private ProductRepository repository;

	// Camada servico faz chamada camada repository
	public List<Product>  findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id){
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
