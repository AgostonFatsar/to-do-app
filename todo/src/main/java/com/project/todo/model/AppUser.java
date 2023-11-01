package com.project.todo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

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
    String userName;
    String password;
    Role role;
    @OneToMany(mappedBy = "appUser", cascade = CascadeType.REMOVE)
    Set<TaskGroup> groups;
}
