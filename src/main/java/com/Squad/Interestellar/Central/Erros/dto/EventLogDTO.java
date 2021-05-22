package com.Squad.Interestellar.Central.Erros.dto;

import com.Squad.Interestellar.Central.Erros.entity.EventLog;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class EventLogDTO {

 private Long id;

 private EventLog.@NotNull levelType level;

 private String description;

 private String source;

 private int quantity;

 private LocalDateTime date;

 public EventLogDTO(final EventLog eventLog) {
  this.id = eventLog.getId();
  this.level = eventLog.getLevel();
  this.description = eventLog.getDescription();
  this.source = eventLog.getSource();
  this.quantity = eventLog.getQuantity();
  this.date = eventLog.getDate();
 }
}
