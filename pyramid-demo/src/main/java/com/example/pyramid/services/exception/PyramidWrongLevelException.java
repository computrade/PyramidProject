package com.example.pyramid.services.exception;

public class PyramidWrongLevelException extends RuntimeException{
	
	private static final long serialVersionUID = -3589502104745518360L;

	public PyramidWrongLevelException(String message) {
		super(message);
	}

	public PyramidWrongLevelException(String message, Throwable cause) {
		super(message, cause);
	}

	public PyramidWrongLevelException(Throwable cause) {
		super(cause);
	}

}
