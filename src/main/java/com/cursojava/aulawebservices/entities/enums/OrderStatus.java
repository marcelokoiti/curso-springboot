package com.cursojava.aulawebservices.entities.enums;

//Por padrão o Java atribui automatico valor zero, 1, 2 , etc..  conforme sequência declarado
//Se for incluindo um outro STATUS no meio, os valores ja postados na BD ficara inconsistente
//Para evitar este possivel problema, atribuimos os valores de forma Manual

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

// Para atribuir valor fixo para enum, Java exige as seguintes implementacoes:
	private int code;						// Codigo do tipo enum

// construtor para tipo enum eh um caso especial e é  "private"
	private OrderStatus(int code) {        
		this.code = code;
	}

// metodo publico para acessa o code
	public int getCode() {
		return code;
	}

// Tranforma codigo nos valores do enum OrderStatus
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
	    }
		throw new IllegalArgumentException("Invalid Order Status code:" + code);
	}
}
