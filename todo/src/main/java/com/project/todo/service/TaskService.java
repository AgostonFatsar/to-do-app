package com.project.todo.service;

import com.project.todo.model.Task;
import com.project.todo.data.TaskRepository;
import com.project.todo.data.TaskGroupRepository;
import com.project.todo.model.dto.DtoFactory;
import com.project.todo.model.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskGroupRepository groupRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskGroupRepository groupRepository) {
        this.taskRepository = taskRepository;
        this.groupRepository = groupRepository;
    }

    public List<TaskDTO> getTasks() {
        return taskRepository.findAll().stream()
                .map(DtoFactory::buildDTO)
                .collect(Collectors.toList());
    }

    public void addTask(TaskDTO taskDto) {
        Task task = Task.builder()
                        .name(taskDto.getName())
                        .description(taskDto.getDescription())
                        .dateOfCreation(taskDto.getDateOfCreation())
                        .scheduledTime(taskDto.getScheduledTime())
                        .taskLengthInMinutes(taskDto.getTaskLengthInMinutes())
                        .taskStatus(taskDto.getTaskStatus())
                        .group(groupRepository.getReferenceById(taskDto.getGroupId()))
                .build();
        taskRepository.save(task);
    }


    public void updateTask(Long id, TaskDTO taskDTO) {
        Task taskToUpdate = taskRepository.getReferenceById(id);
        taskToUpdate.setName(taskDTO.getName());
        taskToUpdate.setDescription(taskDTO.getDescription());
        taskToUpdate.setScheduledTime(taskDTO.getScheduledTime());
        taskToUpdate.setTaskLengthInMinutes(taskDTO.getTaskLengthInMinutes());
        taskToUpdate.setTaskStatus(taskDTO.getTaskStatus());
        taskToUpdate.setGroup(groupRepository.getReferenceById(taskDTO.getGroupId()));
        taskRepository.save(taskToUpdate);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
