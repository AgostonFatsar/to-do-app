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
public class TaskGroup {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    private AppUser appUser;
    @OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE)
    private Set<Task> tasks;
}
