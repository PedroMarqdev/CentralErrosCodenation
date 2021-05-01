package com.Squad.Interestellar.Central.Erros.service.interfaces;

import com.Squad.Interestellar.Central.Erros.dto.EventLogDTO;
import com.Squad.Interestellar.Central.Erros.entity.EventLog;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface EventLogServiceInterface {
    List<EventLogDTO> findAll(Pageable pageable);

    Optional<EventLog> findById(Long id);

    void deleteEventLog(Long id);

    EventLog save(EventLog eventLog);
}
