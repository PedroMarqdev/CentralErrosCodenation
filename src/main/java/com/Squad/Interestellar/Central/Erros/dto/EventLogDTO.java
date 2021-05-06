package com.Squad.Interestellar.Central.Erros.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventLogDTO {

 private Long id;

 private String level;

 private String description;

 private String source;

 private int quantity;

 private LocalDateTime date;
}
