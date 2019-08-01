package com.wearperfect.datastoreapi.exceptionhandlers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.wearperfect.datastoreapi.exceptions.NotImplementedException;
import com.wearperfect.datastoreapi.exceptions.ResourceNotFoundException;
import com.wearperfect.datastoreapi.exceptions.ServiceUnavailableException;
import com.wearperfect.datastoreapi.exceptions.AuthenticationFailureException;
import com.wearperfect.datastoreapi.exceptions.AuthorizationFailureException;

import lombok.Data;

/**
 * @author teja
 *
 */
@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler({ HttpStatusCodeException.class, AuthenticationFailureException.class,
			AuthorizationFailureException.class, ResourceNotFoundException.class, NotImplementedException.class,
			ServiceUnavailableException.class, Exception.class })
	public ResponseEntity<GlobalRestExceptionResponseEntity> handleExceptions(Exception exception,
			HttpServletRequest request, HttpServletResponse response) {

		GlobalRestExceptionResponseEntity responseEntity = new GlobalRestExceptionResponseEntity();
		responseEntity.setMessage(exception.getMessage());
		responseEntity.setTimestamp(new Date());

		if (exception instanceof HttpStatusCodeException) {
			setGlobalRestExceptionResponseEntityDetailsByStatusCode(responseEntity,
					((HttpStatusCodeException) exception).getStatusCode());
			return new ResponseEntity<GlobalRestExceptionHandler.GlobalRestExceptionResponseEntity>(responseEntity,
					((HttpStatusCodeException) exception).getStatusCode());
		} else if (exception instanceof AuthenticationFailureException) {
			// HTTP Status Code: 401
			setGlobalRestExceptionResponseEntityDetailsByStatusCode(responseEntity, HttpStatus.UNAUTHORIZED);
			return new ResponseEntity<GlobalRestExceptionHandler.GlobalRestExceptionResponseEntity>(responseEntity,
					HttpStatus.UNAUTHORIZED);
		} else if (exception instanceof AuthorizationFailureException) {
			// HTTP Status Code: 403
			setGlobalRestExceptionResponseEntityDetailsByStatusCode(responseEntity, HttpStatus.FORBIDDEN);
			return new ResponseEntity<GlobalRestExceptionHandler.GlobalRestExceptionResponseEntity>(responseEntity,
					HttpStatus.FORBIDDEN);
		} else if (exception instanceof ResourceNotFoundException) {
			// HTTP Status Code: 404
			setGlobalRestExceptionResponseEntityDetailsByStatusCode(responseEntity, HttpStatus.NOT_FOUND);
			return new ResponseEntity<GlobalRestExceptionHandler.GlobalRestExceptionResponseEntity>(responseEntity,
					HttpStatus.NOT_FOUND);
		} else if (exception instanceof NotImplementedException) {
			// HTTP Status Code: 501
			setGlobalRestExceptionResponseEntityDetailsByStatusCode(responseEntity, HttpStatus.NOT_IMPLEMENTED);
			return new ResponseEntity<GlobalRestExceptionHandler.GlobalRestExceptionResponseEntity>(responseEntity,
					HttpStatus.NOT_IMPLEMENTED);
		} else if (exception instanceof ServiceUnavailableException) {
			// HTTP Status Code: 503
			setGlobalRestExceptionResponseEntityDetailsByStatusCode(responseEntity, HttpStatus.SERVICE_UNAVAILABLE);
			return new ResponseEntity<GlobalRestExceptionHandler.GlobalRestExceptionResponseEntity>(responseEntity,
					HttpStatus.SERVICE_UNAVAILABLE);
		} else {
			// HTTP Status Code: 500
			setGlobalRestExceptionResponseEntityDetailsByStatusCode(responseEntity, HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<GlobalRestExceptionHandler.GlobalRestExceptionResponseEntity>(responseEntity,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private void setGlobalRestExceptionResponseEntityDetailsByStatusCode(
			GlobalRestExceptionResponseEntity responseEntity, HttpStatus status) {

		responseEntity.setStatus(status.value());
		responseEntity.setError(status.getReasonPhrase());

		switch (status) {
		case UNAUTHORIZED:
			if (responseEntity.getMessage() == null || responseEntity.getMessage().isEmpty()) {
				responseEntity.setMessage("Authentication Failure.");
			}
			break;
		case FORBIDDEN:
			if (responseEntity.getMessage() == null || responseEntity.getMessage().isEmpty()) {
				responseEntity.setMessage("Access Denied.");
			}
			break;
		case NOT_FOUND:
			if (responseEntity.getMessage() == null || responseEntity.getMessage().isEmpty()) {
				responseEntity.setMessage("Resource not found.");
			}
			break;
		case NOT_IMPLEMENTED:
			if (responseEntity.getMessage() == null || responseEntity.getMessage().isEmpty()) {
				responseEntity.setMessage("Feature not implemented yet!");
			}
			break;
		case SERVICE_UNAVAILABLE:
			if (responseEntity.getMessage() == null || responseEntity.getMessage().isEmpty()) {
				responseEntity.setMessage("Service Unavailable.");
			}
			break;
		default:
			if (responseEntity.getMessage() == null || responseEntity.getMessage().isEmpty()) {
				responseEntity.setMessage("Oops! Something went wrong.");
			}
			break;
		}
	}

	@Data
	private class GlobalRestExceptionResponseEntity {
		Date timestamp;
		int status;
		String error;
		String message;
	}
}
