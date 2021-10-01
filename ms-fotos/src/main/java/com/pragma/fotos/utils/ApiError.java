package com.pragma.fotos.utils;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApiError {

    private HttpStatus status;
    private String message;
    private Date timestamp;
    private String details;
    
    public ApiError(HttpStatus status, String message, Date timestamp,String details) {
        super();
        this.details=details;
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
    public ApiError(HttpStatus status, String message, Date timestamp) {
        super();
        this.status=status;        
        this.message = message;        
        this.timestamp = timestamp;
    }
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
    
    
}
