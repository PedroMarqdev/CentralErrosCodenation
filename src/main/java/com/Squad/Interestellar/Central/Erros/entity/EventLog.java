package com.Squad.Interestellar.Central.Erros.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "logs")
public class EventLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public enum levelType {
        WARNING, ERROR, INFO
    }

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private levelType level;

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
    @Min(1)
    private int quantity;

    @Column
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime date;
}
