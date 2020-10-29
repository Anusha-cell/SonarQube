package com.galaxe.sonarQube.exception;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
 
@XmlRootElement(name = "error")
@Data
public class ErrorResponse 
{
    public ErrorResponse(String message) {
        super();
        this.message = message;
    }
 
    private String message;
 
    
}