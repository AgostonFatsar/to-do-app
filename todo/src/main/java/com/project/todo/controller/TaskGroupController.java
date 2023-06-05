package com.project.todo.controller;

import com.project.todo.model.dto.TaskGroupDTO;
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
    public List<TaskGroupDTO> getGroups() {
        return service.getGroups();
    }

    @PostMapping
    public void addGroup(@RequestBody TaskGroupDTO groupDTO) {
        service.addGroup(groupDTO);
    }

    @PutMapping("/{groupId}")
    public void updateGroup(@PathVariable Long groupId, @RequestBody TaskGroupDTO groupDTO) {
        service.updateGroup(groupId, groupDTO);
    }

    @DeleteMapping("/{groupId}")
    public void deleteGroup(@PathVariable Long groupId) {
        service.deleteGroup(groupId);
    }
}
