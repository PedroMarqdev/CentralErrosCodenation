package com.Squad.Interestellar.Central.Erros.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserControllerAdvice {

 @ResponseBody
 @ResponseStatus(HttpStatus.BAD_REQUEST)
 @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
 public String SQLIntegrityConstraintViolationException(final Exception ex) {
	return "Email já cadastrado";
 }

 @ResponseBody
 @ResponseStatus(HttpStatus.BAD_REQUEST)
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public Map<String, String> handleValidationExceptions(final MethodArgumentNotValidException ex) {
	final Map<String, String> errors = new HashMap<>();
	ex.getBindingResult().getAllErrors().forEach((error) -> {
	 final String fieldName = ((FieldError) error).getField();
	 final String errorMessage = error.getDefaultMessage();
	 errors.put(fieldName, errorMessage);
	});
	return errors;
 }
}
