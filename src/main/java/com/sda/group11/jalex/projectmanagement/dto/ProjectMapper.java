package com.sda.group11.jalex.projectmanagement.dto;

import com.sda.group11.jalex.projectmanagement.model.Project;
import com.sda.group11.jalex.projectmanagement.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectMapper {

    public ProjectMapper() {
    }

    public List<ProjectResponse> toDto(List<Project> projects) {
        return projects.stream()       // convert list to stream
                .map(this::toDto)   // convert entity to dto
                .collect(Collectors.toList());  // convert stream to list
    }

    public ProjectResponse toDto(Project project) {
        ProjectResponse dto = new ProjectResponse();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        return dto;
    }

    public List<Project> toEntity(List<ProjectRequest> projectRequests) {
        List<Project> projects = new ArrayList<>();
        for (ProjectRequest projectRequest : projectRequests) {
            projects.add(toEntity(projectRequest));
        }
        return projects;
    }

    public Project toEntity(ProjectRequest projectRequest) {
        Project entity = new Project();
        entity.setId(projectRequest.getId());
        entity.setName(projectRequest.getName());
        entity.setDescription(projectRequest.getDescription());
        User user = new User();
        user.setId(projectRequest.getUserId());
        entity.setUser(user);
        return entity;
    }
}
