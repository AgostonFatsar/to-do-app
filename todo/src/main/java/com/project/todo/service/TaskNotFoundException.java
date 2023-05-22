package com.project.todo.service;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException() {
        super("Task not found!");
    }
}
