package com.Squad.Interestellar.Central.Erros.service.interfaces;

import com.Squad.Interestellar.Central.Erros.entity.EventLog;

import java.util.List;
import java.util.Optional;

public interface EventLogServiceInterface {
    List<EventLog> findAll();

    Optional<EventLog> findById(Long id);

    EventLog editEventLog(EventLog eventLog);

    String deleteEventLog(Long id);

    EventLog save(EventLog eventLog);
}
