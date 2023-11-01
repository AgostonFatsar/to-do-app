package com.project.todo.service;

import com.project.todo.data.UserRepository;
import com.project.todo.model.AppUser;
import com.project.todo.model.Role;
import com.project.todo.model.dto.UserDTO;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public Cookie register(UserDTO userDTO) {
        AppUser user = AppUser.builder()
                .userName(userDTO.getUserName())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        return jwtService.getAuthCookie(user);

    }

    public Cookie authenticate(UserDTO userDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDTO.getUserName(),
                        userDTO.getPassword()
                )
        );
        AppUser user = repository.findAppUserByUserName(userDTO.getUserName())
                .orElseThrow();
        return jwtService.getAuthCookie(user);
    }


}
