package com.cursojava.aulawebservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.aulawebservices.entities.User;

//Aula310
// O SPRING JPA já tem implementacao PADRAO para interface
// Nao é necessario implementar

public interface UserRepository extends JpaRepository<User, Long> {

}
