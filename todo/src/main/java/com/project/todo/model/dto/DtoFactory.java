package com.project.todo.model.dto;

import com.project.todo.model.AppUser;
import com.project.todo.model.Task;
import com.project.todo.model.TaskGroup;

import java.util.stream.Collectors;

public class DtoFactory {

    public static TaskDTO buildDTO(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .dateOfCreation(task.getDateOfCreation())
                .scheduledTime(task.getScheduledTime())
                .taskLengthInMinutes(task.getTaskLengthInMinutes())
                .taskStatus(task.getTaskStatus())
                .groupId(task.getGroup().getId())
                .build();
    }

    public static TaskGroupDTO buildDTO(TaskGroup taskGroup) {
        return TaskGroupDTO.builder()
                .id(taskGroup.getId())
                .name(taskGroup.getName())
                .userId(taskGroup.getAppUser().getId())
                .taskIds(taskGroup.getTasks().stream()
                        .map(Task::getId).collect(Collectors.toSet()))
                .build();
    }

    public static UserDTO buildDTO(AppUser user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .groupIds(user.getGroups().stream()
                        .map(TaskGroup::getId).collect(Collectors.toSet()))
                .build();
    }
}
