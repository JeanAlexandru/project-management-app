package com.sda.group11.jalex.projectmanagement.dto;

public class ProjectRequest {

    private Long id;
    private String name;
    private String description;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }
}
