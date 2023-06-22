package com.project.todo.service;

import com.project.todo.data.UserRepository;
import com.project.todo.model.AppUser;
import com.project.todo.model.Role;
import com.project.todo.model.dto.DtoFactory;
import com.project.todo.model.dto.UserDTO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class UserService implements UserDetailsService {


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
                .role(Role.USER)
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = repository.findAppUserByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new User(user.getUserName(), user.getPassword(), authorities);
    }
}
