package com.example.pyramid.services.exception;

public class PyramidBadRequestException extends RuntimeException{
	
	private static final long serialVersionUID = -3589502104745518360L;

	public PyramidBadRequestException(String message) {
		super(message);
	}

	public PyramidBadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public PyramidBadRequestException(Throwable cause) {
		super(cause);
	}

}
