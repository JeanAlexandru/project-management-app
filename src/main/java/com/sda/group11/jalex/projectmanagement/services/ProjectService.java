package com.sda.group11.jalex.projectmanagement.services;

import com.sda.group11.jalex.projectmanagement.model.Project;
import com.sda.group11.jalex.projectmanagement.model.User;
import com.sda.group11.jalex.projectmanagement.repositories.ProjectRepository;
import com.sda.group11.jalex.projectmanagement.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private static final Logger log = LoggerFactory.getLogger(ProjectService.class);

    private ProjectRepository projectRepository;
    private final  UserRepository userRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    // CRUD
    // save
    public Project save(Project project){
        User user = userRepository.findById(project.getUser().getId()).orElseThrow(()->new RuntimeException("User doesn't exist!"));
        project.setUser(user);
        return projectRepository.save(project);
    }

    // findAll
    public List<Project> findAll() {
        log.debug("find all projects...");
        return projectRepository.findAll();
    }

    // findById
    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("project not found"));
    }

    // update
    public Project update(Long id, Project request) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        updateFields(request, project);

        return projectRepository.save(project);
    }

    private void updateFields(Project request, Project project) {
        project.setName(request.getName());
        project.setDescription(request.getDescription());
    }

    // delete
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("project not found"));
    }

}
