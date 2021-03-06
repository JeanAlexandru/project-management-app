package com.sda.group11.jalex.projectmanagement.controller;

import com.sda.group11.jalex.projectmanagement.dto.*;
import com.sda.group11.jalex.projectmanagement.model.User;
import com.sda.group11.jalex.projectmanagement.repositories.UserRepository;
import com.sda.group11.jalex.projectmanagement.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = UserResources.API_USER)
public class UserResources {
    private static final Logger log = LoggerFactory.getLogger(UserResources.class);

    public static final String API_USER = "/api/users";

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;


    @Autowired
    public UserResources(UserService userService, UserMapper userMapper, UserRepository userRepository) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<User> allUsers = userService.findAll();
        List<UserResponse> allUsersToDto = userMapper.toDto(allUsers);
        return new ResponseEntity<>(allUsersToDto, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> findByUsername(@PathVariable(name = "username") String username) {
        return userService.findByUsername(username)
                .map(userMapper::toDto)
                .map(userResponse -> new ResponseEntity<>(userResponse, HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // create
    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request) {
        User user = userMapper.toEntity(request);
        User savedUser = userService.save(user);
        UserResponse userResponse = userMapper.toDto(savedUser);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable(name = "id") Long id,
                                               @RequestBody UserRequest request) {
        User user = userMapper.toEntity(request);
        User updatedUser = userService.update(id, user);
        UserResponse userResponse = userMapper.toDto(updatedUser);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>("user deleted", HttpStatus.OK);
    }

}
