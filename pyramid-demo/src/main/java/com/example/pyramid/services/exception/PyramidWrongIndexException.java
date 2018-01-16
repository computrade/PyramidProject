package com.example.pyramid.services.exception;

public class PyramidWrongIndexException extends RuntimeException{
	
	private static final long serialVersionUID = -3589502104745518360L;

	public PyramidWrongIndexException(String message) {
		super(message);
	}

	public PyramidWrongIndexException(String message, Throwable cause) {
		super(message, cause);
	}

	public PyramidWrongIndexException(Throwable cause) {
		super(cause);
	}

}
