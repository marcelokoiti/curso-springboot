package com.cursojava.aulawebservices.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cursojava.aulawebservices.entities.User;
import com.cursojava.aulawebservices.services.UserService;

// RESOURCE layer - Recurso WEB referente a entidade User

// Annotation do SPRING.  Recurso WEB implementando por controlador REST
@RestController
//Indica caminho do recurso
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
//Indica que o metodo responde a requisicao tipo GET do HTTP
	@GetMapping
// ResponseEntity - tipo de retorno especifico do spring para retorno requisicao WEB
// Metodo que é um end-point para acessar os usuarios 
	public ResponseEntity<List<User>> findAll() {
		
		List<User> list = service.findAll();
		
// ResponseEntity.ok - resposta com sucesso do HTTP, com corpo do objeto u
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findbyId(@PathVariable Long id) {
		User obj = service.findById(id);

		// ResponseEntity.ok - resposta com sucesso do HTTP, com corpo do objeto u
		return ResponseEntity.ok().body(obj);
	}

	//@RequestBody - Indica que o objeto obj quando chegar no JSON será desserializado
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
//		return ResponseEntity.ok().body(obj);          // Retorna 200
//      Para retornar 201, fazer o camando abaixo:
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}	

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj =  service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}