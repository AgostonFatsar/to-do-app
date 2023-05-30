package com.project.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private LocalDate dateOfCreation;
    private LocalDate scheduledTime;
    private Duration taskLength;
    private TaskStatus taskStatus;

}
