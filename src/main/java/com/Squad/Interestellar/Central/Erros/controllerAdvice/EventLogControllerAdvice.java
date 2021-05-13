package com.Squad.Interestellar.Central.Erros.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EventLogControllerAdvice {
 @ResponseBody
 @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
 @ExceptionHandler(IllegalArgumentException.class)
 public Map<String, String> IllegalArgumentException(final Exception ex) {
	final Map<String, String> error = new HashMap<>();
  if(ex.getMessage().contains("No enum constant")) {
	 error.put("error", "Esse campo apenas aceita valores como: ERROR, INFO e WARNING" );
	 return error;
	};
	error.put("error", "Argumento inválido em algum campo" );
	return error;
 }
}
