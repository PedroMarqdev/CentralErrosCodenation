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

@RestController
@RequestMapping("/loggers")
public class EventLogController {

    @Autowired
    private EventLogService logService;

    @GetMapping
    public Iterable<EventLogDTO> findAll(Pageable pageable) {return this.logService.findAll(pageable);}

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id){
        return new ResponseEntity<String>(this.logService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getEventLog(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EventLog> create(@Valid @RequestBody EventLog eventLog) {
        return new ResponseEntity<EventLog>(this.logService.save(eventLog), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        this.logService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        this.logService.deleteEventLog(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
