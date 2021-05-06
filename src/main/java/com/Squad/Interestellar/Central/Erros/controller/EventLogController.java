package com.Squad.Interestellar.Central.Erros.controller;


import com.Squad.Interestellar.Central.Erros.dto.EventLogDTO;
import com.Squad.Interestellar.Central.Erros.entity.EventLog;
import com.Squad.Interestellar.Central.Erros.service.impl.EventLogService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(
            value = "Retorna todos os logs com possibilidade de filtro",
            notes = "O filter deve ser o nome de uma das colunas a serem filtradas e value o valor que queremos buscar"
    )
    public Iterable<EventLogDTO> findAll(
            @PathParam("filter") String filter,
            @PathParam("value") String value,
            Pageable pageable
    ) {

	if (filter != null && value != null) return this.logService
			.findAllByFilter(filter, value, pageable);

	return this.logService
			.findAll(pageable);
 }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um log pelo id")
    public ResponseEntity<String> getById(@PathVariable Long id){
        return new ResponseEntity<String>(
                this.logService
                        .findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                        .getEventLog(),
                HttpStatus.OK
        );
    }

    @PostMapping
    @ApiOperation(value = "Cadastra um log")
    public ResponseEntity<EventLog> create(@Valid @RequestBody EventLog eventLog) {
        return new ResponseEntity<EventLog>(
                this.logService
                        .save(eventLog),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui um log pelo Id")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        this.logService
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	this.logService
			.deleteEventLog(id);

	return new ResponseEntity<String>(HttpStatus.OK);
 }
}
