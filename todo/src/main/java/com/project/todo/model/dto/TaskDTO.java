package com.project.todo.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.todo.model.TaskStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TaskDTO {

    private Long id;
    private String name;
    private String description;
    @CreationTimestamp
    private Date dateOfCreation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date scheduledTime;
    private Long taskLengthInMinutes;
    private TaskStatus taskStatus;
    private Long groupId;
}
