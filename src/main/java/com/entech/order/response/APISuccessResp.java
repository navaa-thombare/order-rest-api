package com.entech.order.response;

import java.util.List;

import org.springframework.http.HttpStatus;

public class APISuccessResp extends APIResponse {
	Object respObject;

	public APISuccessResp() {
		super();
	}
	
	public APISuccessResp(HttpStatus status) {
		super(status);
		setResponseStatus("SUCCESS");
		setStatusCode(0);
	}
	
	public APISuccessResp(HttpStatus status, String msg, Object respObj) {
		super(status,msg);
		this.respObject = respObj;
		setResponseStatus("SUCCESS");
		setStatusCode(0);
		setRespCount(respObj instanceof List<?> ? ((List<?>) respObj).size() : 1);
	}
	
	public APISuccessResp(HttpStatus status, Object respObj) {
		super(status);
		this.respObject = respObj;
	}

	public Object getRespObject() {
		return respObject;
	}

	public void setRespObject(Object respObject) {
		this.respObject = respObject;
	}
	
	

}
