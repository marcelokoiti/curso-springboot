package com.cursojava.aulawebservices.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.aulawebservices.entities.Order;
import com.cursojava.aulawebservices.services.OrderService;

// RESOURCE layer - Recurso WEB referente a entidade Order

// Annotation.  Recurso WEB implementando por controlador REST
@RestController
//Indica caminho do recurso
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
//Indica que o metodo responde a requisicao tipo GET do HTTP
	@GetMapping
// ResponseEntity - tipo de retorno especifico do spring para retorno requisicao WEB
// Metodo que é um end-point para acessar os usuarios 
	public ResponseEntity<List<Order>> findAll() {
		
		List<Order> list = service.findAll();
		
// ResponseEntity.ok - resposta com sucesso do HTTP, com corpo do objeto u
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findbyId(@PathVariable Long id) {
		Order obj = service.findById(id);

		// ResponseEntity.ok - resposta com sucesso do HTTP, com corpo do objeto u
		return ResponseEntity.ok().body(obj);
	}
}