package br.ufpb.odravison.monolithicapplication.models;

import org.springframework.http.HttpStatus;

public class CallHistory {
	
	private String methodCalled;
	private HttpStatus httpStatus;
	
	public CallHistory(){
		
	}
	
	public CallHistory(String methodCalled, HttpStatus httpStatus){
		this.methodCalled = methodCalled;
		this.httpStatus = httpStatus;
	}

	public String getMethodCalled() {
		return methodCalled;
	}

	public void setMethodCalled(String methodCalled) {
		this.methodCalled = methodCalled;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
	
	

}
