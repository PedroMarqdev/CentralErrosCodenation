package com.Squad.Interestellar.Central.Erros.dto;

import com.Squad.Interestellar.Central.Erros.entity.EventLog;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
public class EventLogDTO {

    private Long id;

    private String level;

    private String description;

    private String source;

    private int quantity;

    private LocalDateTime date;
}
