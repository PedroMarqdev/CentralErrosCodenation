package com.Squad.Interestellar.Central.Erros.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "logs")
public class EventLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    @NotBlank
    @Size(max = 15)
    private String level;

    @Column
    @NotNull
    @NotBlank
    private String description;

    @Column
    @NotNull
    @NotBlank
    private String eventLog;

    @Column
    @NotNull
    @NotBlank
    private String source;

    @Column
    @NotNull
    @NotBlank
    private int quantity;

    @Column
    @NotNull
    @NotBlank
    @CreatedDate
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime date;
}
