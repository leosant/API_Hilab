package com.hilab.api_people.service.exception;

public class ConstraintViolationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ConstraintViolationException(String msg) {
		super(msg);
	}
}
