package com.Squad.Interestellar.Central.Erros.service.impl;

import com.Squad.Interestellar.Central.Erros.dto.EventLogDTO;
import com.Squad.Interestellar.Central.Erros.entity.EventLog;
import com.Squad.Interestellar.Central.Erros.repository.EventLogRepository;
import com.Squad.Interestellar.Central.Erros.service.interfaces.EventLogServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.management.modelmbean.ModelMBean;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.Pageable;

@Service
public class EventLogService implements EventLogServiceInterface {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EventLogRepository eventLogRepository;

    @Override
    public List<EventLogDTO> findAll(Pageable pageable) {

        return eventLogRepository.findAll(pageable).stream().map((e) -> modelMapper.map(e, EventLogDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<EventLogDTO> findAllByFilter(String filter, String value, Pageable pageable) {

        if (filter.equals("level")) return eventLogRepository.findByLevelLike(EventLog.levelType.valueOf(value), pageable).stream().map((e) -> modelMapper.map(e, EventLogDTO.class)).collect(Collectors.toList());

        if (filter.equals("quantity")) return eventLogRepository.findByQuantity(Integer.parseInt(value), pageable).stream().map((e) -> modelMapper.map(e, EventLogDTO.class)).collect(Collectors.toList());

        if (filter.equals("description")) return eventLogRepository.findByDescriptionLike(value, pageable).stream().map((e) -> modelMapper.map(e, EventLogDTO.class)).collect(Collectors.toList());

        if (filter.equals("source")) return eventLogRepository.findBySourceLike(value, pageable).stream().map((e) -> modelMapper.map(e, EventLogDTO.class)).collect(Collectors.toList());

        return null;

        //return eventLogRepository.findAllByFilter(queryString, pageable).stream().map((e) -> modelMapper.map(e, EventLogDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<EventLog> findById(Long id) {
        return eventLogRepository.findById(id);
    }

    @Override
    public void deleteEventLog(Long id) {
        eventLogRepository.deleteById(id);
    }

    @Override
    public EventLog save(EventLog eventLog) {
        return eventLogRepository.save(eventLog);
    }

}
