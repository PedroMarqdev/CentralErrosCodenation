package com.Squad.Interestellar.Central.Erros.controller;


import com.Squad.Interestellar.Central.Erros.dto.EventLogDTO;
import com.Squad.Interestellar.Central.Erros.entity.EventLog;
import com.Squad.Interestellar.Central.Erros.service.impl.EventLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/loggers")
public class EventLogController {

 @Autowired
 private EventLogService logService;

 @GetMapping
 public Iterable<EventLogDTO> findAll(@PathParam("filter") final String filter, @PathParam("value") final String value, final Pageable pageable) {

	if (filter != null && value != null) return this.logService
			.findAllByFilter(filter, value, pageable);

	return this.logService
			.findAll(pageable);
 }

 @GetMapping("/{id}")
 public ResponseEntity<String> getById(@PathVariable final Long id) {
	return new ResponseEntity<String>(
			this.logService
					.findById(id)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
					.getEventLog(),
			HttpStatus.OK
	);
 }

 @PostMapping
 public ResponseEntity<EventLog> create(@Valid @RequestBody final EventLog eventLog) {
	return new ResponseEntity<EventLog>(
			this.logService
					.save(eventLog),
			HttpStatus.CREATED
	);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<String> deleteById(@PathVariable final Long id) {
	this.logService
			.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	this.logService
			.deleteEventLog(id);

	return new ResponseEntity<String>(HttpStatus.OK);
 }
}
