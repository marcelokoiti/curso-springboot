package com.cursojava.aulawebservices.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.aulawebservices.entities.Product;
import com.cursojava.aulawebservices.services.ProductService;

// RESOURCE layer - Recurso WEB referente a entidade Product

// Annotation.  Recurso WEB implementando por controlador REST
@RestController
//Indica caminho do recurso
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
//Indica que o metodo responde a requisicao tipo GET do HTTP
	@GetMapping
// ResponseEntity - tipo de retorno especifico do spring para retorno requisicao WEB
// Metodo que é um end-point para acessar os usuarios 
	public ResponseEntity<List<Product>> findAll() {
		
		List<Product> list = service.findAll();
		
// ResponseEntity.ok - resposta com sucesso do HTTP, com corpo do objeto u
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findbyId(@PathVariable Long id) {
		Product obj = service.findById(id);

		// ResponseEntity.ok - resposta com sucesso do HTTP, com corpo do objeto u
		return ResponseEntity.ok().body(obj);
	}
}