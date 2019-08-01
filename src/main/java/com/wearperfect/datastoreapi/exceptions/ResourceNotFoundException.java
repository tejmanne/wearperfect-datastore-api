package com.wearperfect.datastoreapi.exceptions;

/**
 * @author teja
 *
 */
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -6893721474187601752L;

	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
