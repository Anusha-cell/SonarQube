package com.galaxe.sonarQube.exception;


 
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
 
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse("Server Error");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
    @ExceptionHandler(ResourceFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(ResourceFoundException ex, WebRequest request) {
       
        ErrorResponse error = new ErrorResponse("Record Not Found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
    
    @ExceptionHandler(NullPointerException.class)
    public final ResponseEntity<Object> nullPointerException(NullPointerException ex, WebRequest request) {
       
        ErrorResponse error = new ErrorResponse("NullPointerException");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        
        ErrorResponse error = new ErrorResponse("Validation Failed");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}