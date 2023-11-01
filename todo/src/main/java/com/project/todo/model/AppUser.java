package com.project.todo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppUser {

    @Id
    @GeneratedValue
    Long id;
    @Column(unique = true, nullable = false)
    String username;
    String password;
    Role role;
    @OneToMany(mappedBy = "appUser", cascade = CascadeType.REMOVE)
    Set<TaskGroup> groups;
    //TODO add default group
}
