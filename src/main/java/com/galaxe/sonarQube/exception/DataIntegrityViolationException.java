package com.galaxe.sonarQube.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class DataIntegrityViolationException extends RuntimeException {
	
    private static final long serialVersionUID = 1 ;

    public DataIntegrityViolationException(String msg)
    {
        super(msg);

    }
    
    public DataIntegrityViolationException(String msg, Throwable cause)
    {
        super(msg, cause);

    }

	public DataIntegrityViolationException(HttpStatus notFound) {
	}


}
