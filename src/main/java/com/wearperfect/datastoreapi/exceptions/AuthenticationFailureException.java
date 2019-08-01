package com.wearperfect.datastoreapi.exceptions;

/**
 * @author teja
 *
 */
public class AuthenticationFailureException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6254294792184374700L;

	public AuthenticationFailureException() {
		// TODO Auto-generated constructor stub
	}

	public AuthenticationFailureException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AuthenticationFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
