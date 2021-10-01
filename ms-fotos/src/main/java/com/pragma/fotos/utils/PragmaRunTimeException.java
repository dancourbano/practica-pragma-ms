package com.pragma.fotos.utils;

public class PragmaRunTimeException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PragmaRunTimeException(String id) {
        super(String.format(id));
    }
}
