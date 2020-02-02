package com.sda.group11.jalex.projectmanagement.dto;

import com.sda.group11.jalex.projectmanagement.model.Role;
import com.sda.group11.jalex.projectmanagement.model.Task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserResponse {

    private Long id;
    private String name;
    private String password;
    private String email;
    private String displayName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
