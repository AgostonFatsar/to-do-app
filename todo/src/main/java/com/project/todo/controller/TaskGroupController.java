package com.project.todo.controller;

import com.project.todo.model.TaskGroup;
import com.project.todo.service.TaskGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task_group")
public class TaskGroupController {

    private final TaskGroupService service;

    @Autowired
    public TaskGroupController(TaskGroupService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskGroup> getGroups() {
        return service.getGroups();
    }

    @PostMapping
    public void addGroup(@RequestBody TaskGroup group) {
        service.addGroup(group);
    }

    @PutMapping("/{groupId}")
    public void updateGroup(@PathVariable Long groupId, @RequestBody TaskGroup group) {
        service.updateGroup(groupId, group);
    }

    @DeleteMapping("/{groupId}")
    public void deleteGroup(@PathVariable Long groupId) {
        service.deleteGroup(groupId);
    }
}
