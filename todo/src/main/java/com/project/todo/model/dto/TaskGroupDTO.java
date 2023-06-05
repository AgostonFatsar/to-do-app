package com.project.todo.model.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TaskGroupDTO {

    private Long id;
    private String name;
    private Long userId;
    private Set<Long> taskIds;
}
