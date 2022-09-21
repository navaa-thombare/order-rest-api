package com.entech.order.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class APIErrorResp extends APIResponse {
	private LocalDateTime timestamp;

	public APIErrorResp() {
		super();
	}

	public APIErrorResp(HttpStatus status, String msg, int statusCode) {
		super(status,msg);
		this.timestamp = LocalDateTime.now();
		setStatusCode(statusCode);
		setResponseStatus("ERROR");
	}
}
