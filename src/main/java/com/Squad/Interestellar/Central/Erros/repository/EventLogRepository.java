package com.Squad.Interestellar.Central.Erros.repository;

import com.Squad.Interestellar.Central.Erros.entity.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventLogRepository extends JpaRepository<EventLog, Long> {

}
