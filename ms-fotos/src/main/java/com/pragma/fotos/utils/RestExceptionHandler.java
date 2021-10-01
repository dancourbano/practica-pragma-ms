package com.pragma.fotos.utils;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> manejarTodasException(Exception exception, WebRequest request) {
        
		return new ResponseEntity<Object>(new ApiError( HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage(),new Date(),request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> blogNotFoundException(SQLIntegrityConstraintViolationException ioexception, WebRequest request) {
        
		return new ResponseEntity<Object>(new ApiError( HttpStatus.INTERNAL_SERVER_ERROR,ioexception.getMessage(),new Date(),request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(value = PragmaRunTimeException.class)
    public ResponseEntity<Object> pragmaRunTimeException(PragmaRunTimeException ioexception, WebRequest request) {
        
		return new ResponseEntity<Object>(new ApiError( HttpStatus.NOT_FOUND,ioexception.getMessage(),new Date(),request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
}
