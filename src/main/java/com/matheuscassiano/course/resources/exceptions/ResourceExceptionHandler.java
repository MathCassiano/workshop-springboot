package com.matheuscassiano.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matheuscassiano.course.service.exceptions.DatabaseException;
import com.matheuscassiano.course.service.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

//intercepta as exceções que ocorrerem para que o objeto possa executar o tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

	// assim eu digo que meu metodo intercepta qualquer exceção do tipo
	// ResourceNotFoundException e faz o tratamnento que houver dentro

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> dataBase(DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
