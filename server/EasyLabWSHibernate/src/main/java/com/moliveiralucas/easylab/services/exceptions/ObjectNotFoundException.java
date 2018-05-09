package com.moliveiralucas.easylab.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6961025836906239950L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
