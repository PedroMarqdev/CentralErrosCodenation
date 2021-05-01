package com.Squad.Interestellar.Central.Erros.repository;

import com.Squad.Interestellar.Central.Erros.entity.EventLog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventLogRepository extends JpaRepository<EventLog, Long> {

//    @Query(value = "SELECT * FROM logs l " +
//            "WHERE :filter like %:value%", nativeQuery = true)
//    List<EventLog> findAllByFilter(@Param("filter") String filter, @Param("value") String value, Pageable pageable);

    List<EventLog> findByLevelLike(EventLog.levelType value, Pageable pageable);

    List<EventLog> findByQuantity(Integer value, Pageable pageable);

    List<EventLog> findByDescriptionLike(String value, Pageable pageable);

    List<EventLog> findBySourceLike(String value, Pageable pageable);

}
