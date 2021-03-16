package com.cursojava.aulawebservices.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * Esta exception pertence a camada de resources 
*/

/*
 * Por padrao o Spring retorna o seguinte erro:
{
    "timestamp": "2021-03-16T10:27:09.450+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "",
    "path": "/users/6"
}
 */

public class StandardError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape  = JsonFormat.Shape.STRING, pattern="yyy-MM-DD'T'HH:mm:ss'Z'", timezone = "GMT")	
	private Instant timestamp;
	private Integer status;
	private String  error;
	private String message;
	private String path;

	public StandardError() {
	}

	public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
