package com.cursojava.aulawebservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.aulawebservices.entities.Order;
import com.cursojava.aulawebservices.repositories.OrderRepository;

//Camada SERVICE

//registrar a classe  OrderService como COMPONENT
/* Quando um objeto vai ser “injetado”  pelo mecanismo de injeção de dependência do Spring, 
  a CLASSE DESTE OBJETO DEVE SER REGISTRADA no mecanismo de injeção de dependência.
  Ver OrderResource fazendo injecao de OrderService:
  @Autowired
  private OrderService service;
*/
@Service
public class OrderService {

	//Aula311 - Injeção de dependência do framework Spring
	//Associa OrderRepository a OrderService
	@Autowired
	private OrderRepository repository;

	// Camada servico faz chamada camada repository
	public List<Order>  findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id){
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
