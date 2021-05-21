package com.Squad.Interestellar.Central.Erros.service.interfaces;

import com.Squad.Interestellar.Central.Erros.dto.EventLogDTO;
import com.Squad.Interestellar.Central.Erros.entity.EventLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventLogServiceInterface {

 Page<EventLog> findAllByFilter(String filter, String value, Pageable pageable);

 Page<EventLog> findAll(Pageable pageable);

 Optional<EventLog> findById(Long id);

 void deleteEventLog(Long id);

 EventLog save(EventLog eventLog);
}
