package com.project.todo.controller;

import com.project.todo.model.dto.UserDTO;
import com.project.todo.service.AuthenticationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public HttpServletResponse register(HttpServletResponse response, @RequestBody UserDTO userDTO) {
        Cookie jwt = service.register(userDTO);
        response.addCookie(jwt);
        response.setStatus(200);
        return response;
    }

    @PostMapping("/authenticate")
    public HttpServletResponse authenticate(HttpServletResponse response, @RequestBody UserDTO userDto) {
        Cookie jwt = service.authenticate(userDto);
        response.addCookie(jwt);
        response.setStatus(200);
        return response;
    }

}
