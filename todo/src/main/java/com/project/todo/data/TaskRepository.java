package com.project.todo.data;

import com.project.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TaskRepository extends JpaRepository<Task, Long> {

}
