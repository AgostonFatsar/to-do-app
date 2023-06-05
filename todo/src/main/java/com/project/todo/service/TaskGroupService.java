package com.project.todo.service;

import com.project.todo.model.TaskGroup;
import com.project.todo.data.TaskGroupRepository;
import com.project.todo.model.dto.DtoFactory;
import com.project.todo.model.dto.TaskGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskGroupService {

    private final TaskGroupRepository groupRepository;

    @Autowired
    public TaskGroupService(TaskGroupRepository repository) {
        this.groupRepository = repository;
    }

    public List<TaskGroupDTO> getGroups() {
        return groupRepository.findAll().stream()
                .map(DtoFactory::buildDTO)
                .collect(Collectors.toList());
    }

    public void addGroup(TaskGroupDTO groupDTO) {
        TaskGroup group = TaskGroup.builder()
                .name(groupDTO.getName())
                .build();
        groupRepository.save(group);
    }

    public void updateGroup(Long id, TaskGroupDTO groupDTO) {
        TaskGroup groupToUpdate = groupRepository.getReferenceById(id);
        groupToUpdate.setName(groupDTO.getName());
        groupRepository.save(groupToUpdate);
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }

}
