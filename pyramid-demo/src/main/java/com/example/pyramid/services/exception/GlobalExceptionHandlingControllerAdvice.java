package com.example.pyramid.services.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@ControllerAdvice
public class GlobalExceptionHandlingControllerAdvice {

	protected Logger logger;

	public GlobalExceptionHandlingControllerAdvice() {
		logger = LoggerFactory.getLogger(getClass());
	}

	/**
	 * Convert a predefined exception to an HTTP Status code
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST , reason = "Check your request.")
	@ExceptionHandler(PyramidBadRequestException.class)
	public void badRequest() {
		logger.error("Request raised a PyramidbadRequestException");
	}

	/**
	 * Convert a predefined exception to an HTTP Status code
	 * 
	 * @return Exception view.
	 */
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST , reason = "Hint:The index should be positive and less or equal to the level.")
	@ExceptionHandler(PyramidWrongIndexException.class)
	public void wrongIndex() {
		logger.error("Bad Request becuase of PyramidWrongIndexException happens");
		
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST , reason = "Hint:The level should be positive.")
	@ExceptionHandler(PyramidWrongLevelException.class)
	public void wronLevel() {
		logger.error("Bad Request becuase of PyramidWrongLevelException happens");
		
	}

}