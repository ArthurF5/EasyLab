package com.moliveiralucas.easylab.services.exceptions;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 6961025836906239950L;

	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
