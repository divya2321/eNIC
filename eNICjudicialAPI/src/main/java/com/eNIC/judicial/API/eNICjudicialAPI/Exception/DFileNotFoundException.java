package com.eNIC.judicial.API.eNICjudicialAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DFileNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DFileNotFoundException(String exception) {
		super(exception);
	}
	
	public DFileNotFoundException(String exception, Throwable cause) {
		super(exception, cause);
	}

}
