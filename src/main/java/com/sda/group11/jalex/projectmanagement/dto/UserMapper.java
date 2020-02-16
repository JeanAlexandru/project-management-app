package com.sda.group11.jalex.projectmanagement.dto;

import com.sda.group11.jalex.projectmanagement.model.Role;
import com.sda.group11.jalex.projectmanagement.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public List<UserResponse> toDto(List<User> users) {
        return users.stream()       // convert list to stream
                .map(this::toDto)   // convert entity to dto
                .collect(Collectors.toList());  // convert stream to list
    }

    public UserResponse toDto(User user) {
        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public List<User> toEntity(List<UserRequest> userRequests) {
        List<User> users = new ArrayList<>();
        for (UserRequest userRequest : userRequests) {
            users.add(toEntity(userRequest));
        }
        return users;
    }

    public User toEntity(UserRequest userRequest) {
        User entity = new User();
        String roleString = userRequest.getRole();
        entity.setRole(Role.valueOf(roleString)); // convert a string to an enum
        entity.setName(userRequest.getName());
        entity.setPassword(userRequest.getPassword());
        entity.setEmail(userRequest.getEmail());
        return entity;
    }


}
