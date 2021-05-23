package com.eNIC.judicial.API.eNICjudicialAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TokenExpiredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TokenExpiredException(String exception) {
		super(exception);
	}
	
	public TokenExpiredException(String exception, Throwable cause) {
		super(exception, cause);
	}

}
