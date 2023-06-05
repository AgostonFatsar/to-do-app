package com.project.todo.model.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO {

    Long id;
    String userName;
    String password;
    Set<Long> groupIds;
}
