package com.Squad.Interestellar.Central.Erros.service.impl;

import com.Squad.Interestellar.Central.Erros.entity.EventLog;
import com.Squad.Interestellar.Central.Erros.service.interfaces.EventLogServiceInterface;

import java.util.List;
import java.util.Optional;

public class EventLogService implements EventLogServiceInterface {

    private EventLog eventLog;

    @Override
    public List<EventLog> findAll() {
        return null;
    }

    @Override
    public Optional<EventLog> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public EventLog editEventLog(EventLog eventLog) {
        return null;
    }

    @Override
    public String deleteEventLog(Long id) {
        return null;
    }

    @Override
    public EventLog save(EventLog eventLog) {
        return null;
    }
}
