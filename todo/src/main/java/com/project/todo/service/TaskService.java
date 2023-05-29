package com.project.todo.service;

import com.project.todo.model.Task;
import com.project.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void addTask(Task task) {
        repository.save(task);
    }

    public List<Task> getTasks() {
        return repository.findAll();
    }

    public Task getTaskById(Long id) {
        Optional<Task> task = repository.findById(id);
        return task.orElseThrow(TaskNotFoundException::new);
    }

    public void updateTask(Long id, Task task) {
        Task taskToUpdate = getTaskById(id);
        taskToUpdate.setName(task.getName());
        taskToUpdate.setDescription(task.getDescription());
        repository.save(taskToUpdate);
    }

    public void deleteTask(Long taskId) {
        repository.deleteById(taskId);
    }
}
