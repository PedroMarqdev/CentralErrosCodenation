package com.Squad.Interestellar.Central.Erros.service.impl;

import com.Squad.Interestellar.Central.Erros.dto.EventLogDTO;
import com.Squad.Interestellar.Central.Erros.entity.EventLog;
import com.Squad.Interestellar.Central.Erros.repository.EventLogRepository;
import com.Squad.Interestellar.Central.Erros.service.interfaces.EventLogServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventLogService implements EventLogServiceInterface {

 @Autowired
 private ModelMapper modelMapper;

 @Autowired
 private EventLogRepository eventLogRepository;

 @Override
 public Page<EventLog> findAll(Pageable pageable) {
	return eventLogRepository
			.findAll(pageable);
 }

 @Override
 public Page<EventLog> findAllByFilter(final String filter, final String value, final Pageable pageable) {
     Page<EventLog> logs = null;

	if (filter.equals("level")) logs = eventLogRepository
			.findByLevel(EventLog.levelType.valueOf(value), pageable);

	if (filter.equals("quantity")) logs = eventLogRepository
			.findByQuantity(Integer.parseInt(value), pageable);

	if (filter.equals("id")) logs = eventLogRepository
            .findAllById(Long.parseLong(value), pageable);

	if (filter.equals("description")) logs = eventLogRepository
			.findByDescriptionContaining(value, pageable);

	if (filter.equals("source")) logs = eventLogRepository
			.findBySourceContaining(value, pageable);

	if (filter.equals("date")) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	    String[] dateInterval = value.split("and");
	    logs =  eventLogRepository
                .findByDateBetween(
                        LocalDateTime.parse(dateInterval[0], formatter),
                        LocalDateTime.parse(dateInterval[1], formatter),
                        pageable
                    );
        }

	if(logs != null) return logs;

	return null;
 }

 @Override
 public Optional<EventLog> findById(final Long id) {
	return eventLogRepository.findById(id);
 }

 @Override
 public void deleteEventLog(final Long id) {
	eventLogRepository.deleteById(id);
 }

 @Override
 public EventLog save(final EventLog eventLog) {
	return eventLogRepository.save(eventLog);
 }

}
