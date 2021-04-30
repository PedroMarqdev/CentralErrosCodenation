package com.Squad.Interestellar.Central.Erros.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "users", uniqueConstraints={@UniqueConstraint(columnNames={"login"})} )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    @NotNull
    @NotBlank
    @Size(max = 150)
    private String name;

    @Column
    @NotNull
    @NotBlank
    @Email
    private String login;

    @Column
    @NotNull
    @NotBlank
    private String password;
}
