package com.pragma.clientes.utils;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> blogNotFoundException(SQLIntegrityConstraintViolationException ioexception, WebRequest request) {
        
		return new ResponseEntity<Object>(new ApiError( HttpStatus.INTERNAL_SERVER_ERROR,ioexception.getMessage(),new Date(),request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> manejarTodasException(Exception exception, WebRequest request) {
        
		return new ResponseEntity<Object>(new ApiError( HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage(),new Date(),request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ioexception, WebRequest request) {
        
		return new ResponseEntity<Object>(new ApiError( HttpStatus.NOT_FOUND,ioexception.getMessage(),new Date(),request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	 
	@ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Object> dataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request) {
        
		return new ResponseEntity<Object>(new ApiError( HttpStatus.INTERNAL_SERVER_ERROR,
				"No debe duplicarse el Numero Identificador debido a que ya está registrado el Numero de identificacion",
				new Date(),
				request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	 
	
}
