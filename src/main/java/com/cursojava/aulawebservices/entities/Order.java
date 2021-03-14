package com.cursojava.aulawebservices.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cursojava.aulawebservices.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
// Dando o nome da tabela order para tb_order, pois esta dando conflito com palavra order
@Table(name="tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape  = JsonFormat.Shape.STRING, pattern="yyy-MM-DD'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
//	private OrderStatus orderStatus;
// INTERNAMENTE na classe Order fica como Integer para explicitamente grava no BD como inteiro
// EXTERNAMENTE conhecerar o tipo OrderStatus (enum)

	private Integer orderStatus;          
	
    // Indica JPA - Many Order To One User
	@ManyToOne
	// Nome da chave estrangeira de User
	@JoinColumn(name = "client.id")
	//Aula319-referencia ciclica - Order x User
	//No User client incluimos o @JsonIgnore
	private User client;

	//Aula 319-Parte2
	// OrderItemPK @ManyToOne  com Order
	// OrderItemPK é um atributo do OrderItem
	// No OrderItem, temos o id. O id tem o order (pedido)
	
	@OneToMany(mappedBy = "id.order" )
	
	//Aula319-referencia ciclica - Order x OrderItem
	//No OrderItem nao temos o atributo Order de forma direta
	//Temos o id que tem relacao com o Order
	private Set<OrderItem> items = new HashSet<>(); 

	//Mapeamento OneToOne com mesmo id (Order e Payment)-parametro cascade
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	public Order() {
	}

//EXTERNAMENTE mantem no construtor
	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

//EXTERNAMENTE retornando OrderStatus
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

//INTERNAMENTE utilizando inteiro
	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<OrderItem> getItems() {
		return items;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
