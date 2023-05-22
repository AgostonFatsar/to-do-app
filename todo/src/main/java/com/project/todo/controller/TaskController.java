package com.project.todo.controller;

import com.project.todo.model.Task;
import com.project.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getTasks() {
        return service.getTasks();
    }

    @PostMapping
    public void addTask(@RequestBody Task task) {
        service.addTask(task);
    }
}
