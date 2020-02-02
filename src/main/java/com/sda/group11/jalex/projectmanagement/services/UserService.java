package com.sda.group11.jalex.projectmanagement.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.group11.jalex.projectmanagement.dto.UserMapper;
import com.sda.group11.jalex.projectmanagement.dto.UserRequest;
import com.sda.group11.jalex.projectmanagement.dto.UserResponse;
import com.sda.group11.jalex.projectmanagement.model.User;
import com.sda.group11.jalex.projectmanagement.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService (UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // CRUD
    // save
    public UserResponse save(UserRequest userRequest){
        User user = userMapper.toEntity(userRequest);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);

    }

    // findAll
    public List<UserResponse> findAll() {
        log.debug("find all users...");
        List<User> users = userRepository.findAll();
        return userMapper.toDto(users);
    }

    // findById
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));
        return userMapper.toDto(user);
    }

    // update
    public UserResponse update(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        updateFields(request, user);

        User savedUser = userRepository.save(user);

        return userMapper.toDto(savedUser);
    }

    private void updateFields(UserRequest request, User user) {
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
    }

    // delete


    // deleteById



}
