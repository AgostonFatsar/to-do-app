package com.project.todo.controller;

import com.project.todo.model.dto.UserDTO;
import com.project.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return service.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody UserDTO userDto) {
        service.addUser(userDto);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDTO userDto) {
        service.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
