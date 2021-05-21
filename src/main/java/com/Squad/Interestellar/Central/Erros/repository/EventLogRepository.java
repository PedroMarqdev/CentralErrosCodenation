package com.Squad.Interestellar.Central.Erros.repository;

import com.Squad.Interestellar.Central.Erros.entity.EventLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventLogRepository extends JpaRepository<EventLog, Long> {

 Page<EventLog> findByLevel(EventLog.levelType value, Pageable pageable);

 Page<EventLog> findByQuantity(Integer value, Pageable pageable);

 Page<EventLog> findByDescriptionContaining(String value, Pageable pageable);

 Page<EventLog> findBySourceContaining(String value, Pageable pageable);

 Page<EventLog> findByDateBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);

 Page<EventLog> findAllById(Long id, Pageable pageable);
}
