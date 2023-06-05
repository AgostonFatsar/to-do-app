package com.project.todo.service;

import com.project.todo.data.UserRepository;
import com.project.todo.model.AppUser;
import com.project.todo.model.dto.DtoFactory;
import com.project.todo.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> getUsers() {
        return repository.findAll().stream()
                .map(DtoFactory::buildDTO).collect(Collectors.toList());
    }

    public void addUser(UserDTO userDto) {
        AppUser user = AppUser.builder()
                .userName(userDto.getUserName())
                .password(userDto.getPassword())
                .build();
        repository.save(user);
    }

    public void updateUser(Long id, UserDTO userDto) {
        AppUser user = repository.getReferenceById(id);
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
