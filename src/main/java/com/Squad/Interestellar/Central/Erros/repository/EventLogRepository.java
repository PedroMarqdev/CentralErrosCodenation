package com.Squad.Interestellar.Central.Erros.repository;

import com.Squad.Interestellar.Central.Erros.entity.EventLog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventLogRepository extends JpaRepository<EventLog, Long> {

 List<EventLog> findByLevel(EventLog.levelType value, Pageable pageable);

 List<EventLog> findByQuantity(Integer value, Pageable pageable);

 List<EventLog> findByDescriptionContaining(String value, Pageable pageable);

 List<EventLog> findBySourceContaining(String value, Pageable pageable);

}
