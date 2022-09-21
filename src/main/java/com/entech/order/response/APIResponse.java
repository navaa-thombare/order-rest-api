package com.entech.order.response;

import org.springframework.http.HttpStatus;

public class APIResponse {
	private HttpStatus status;
	private String message;
	private String responseStatus;
	private int statusCode;
	private int respCount;
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public int getRespCount() {
		return respCount;
	}
	public void setRespCount(int respCount) {
		this.respCount = respCount;
	}
	public APIResponse() {
		super();
	}
	public APIResponse(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public APIResponse(HttpStatus status) {
		super();
		this.status = status;
	}
	
	
}
