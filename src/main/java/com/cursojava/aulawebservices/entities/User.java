package com.cursojava.aulawebservices.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Interface Serializable - transforma objeto em bytes para trafegar na rede,
// para objeto ser gravado em arquivo, etc..

//Aula302 - Incluir annotations para JPA converter objetos em relacional

//Aula302
@Entity 
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//Aula302 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;

//  Como esta utilizando framework, é obrigatorio construtor vazio
	private User() {
	}

public User(Long id, String name, String email, String phone, String password) {
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.password = password;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

	
}
