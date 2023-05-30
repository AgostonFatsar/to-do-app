package com.project.todo.service;

import com.project.todo.model.TaskGroup;
import com.project.todo.repository.TaskGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskGroupService {

    private final TaskGroupRepository repository;

    @Autowired
    public TaskGroupService(TaskGroupRepository repository) {
        this.repository = repository;
    }

    public List<TaskGroup> getGroups() {
        return repository.findAll();
    }

    public void addGroup(TaskGroup group) {
        repository.save(group);
    }

    public void updateGroup(Long id, TaskGroup group) {
        TaskGroup groupToUpdate = repository.getReferenceById(id);
        groupToUpdate.setName(group.getName());
        repository.save(groupToUpdate);
    }

    public void deleteGroup(Long id) {
        repository.deleteById(id);
    }

}
