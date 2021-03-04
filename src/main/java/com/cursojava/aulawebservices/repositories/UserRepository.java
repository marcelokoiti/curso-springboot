package com.cursojava.aulawebservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.aulawebservices.entities.User;

//Aula310
// O SPRING JPA já tem implementacao PADRAO para interface
// Nao é necessario implementar
/*
Methods inherited from interface org.springframework.data.repository.PagingAndSortingRepository
findAll

Methods inherited from interface org.springframework.data.repository.CrudRepository
count, delete, deleteAll, deleteAll, deleteById, existsById, findById, save

Methods inherited from interface org.springframework.data.repository.query.QueryByExampleExecutor
count, exists, findAll, findOne
*/

public interface UserRepository extends JpaRepository<User, Long> {

}
