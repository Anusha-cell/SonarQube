package com.galaxe.sonarQube.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class NullPointerException extends RuntimeException {

	private static final long serialVersionUID = 1 ;

    public NullPointerException(String message) {
        super(message);
    }

    public NullPointerException(String message, Throwable throwable) {
        super(message, throwable);
    }

	public NullPointerException(HttpStatus notFound) {
	}
}