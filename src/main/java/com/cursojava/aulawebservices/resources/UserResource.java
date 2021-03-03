package com.cursojava.aulawebservices.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.aulawebservices.entities.User;

// RESOURCE layer - Recurso WEB referente a entidade User

// Annotation.  Recurso WEB implementando por controlador REST
@RestController
//Indica caminho do recurso
@RequestMapping(value = "/users")
public class UserResource {

//Indica que o metodo responde a requisicao tipo GET do HTTP
	@GetMapping
// ResponseEntity - tipo de retorno especifico do spring para retorno requisicao WEB
// Metodo que é um end-point para acessar os usuarios 
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@email.com", "4199091234" , "12345");
// ResponseEntity.ok - resposta com sucesso do HTTP, com corpo do objeto u
		return ResponseEntity.ok().body(u);
	}
}