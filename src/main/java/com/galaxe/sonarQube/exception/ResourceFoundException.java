package com.galaxe.sonarQube.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceFoundException extends RuntimeException {

    private static final long serialVersionUID = 1 ;

    public ResourceFoundException(String message) {
        super(message);
    }

    public ResourceFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
