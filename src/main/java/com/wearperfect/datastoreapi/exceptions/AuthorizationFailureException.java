package com.wearperfect.datastoreapi.exceptions;

/**
 * @author teja
 *
 */
public class AuthorizationFailureException extends RuntimeException {
	
	private static final long serialVersionUID = -2377644844447610990L;

	public AuthorizationFailureException() {
		// TODO Auto-generated constructor stub
	}

	public AuthorizationFailureException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AuthorizationFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
