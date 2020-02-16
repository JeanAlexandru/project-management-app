package com.sda.group11.jalex.projectmanagement.controller;

import com.sda.group11.jalex.projectmanagement.dto.ProjectMapper;
import com.sda.group11.jalex.projectmanagement.dto.ProjectRequest;
import com.sda.group11.jalex.projectmanagement.dto.ProjectResponse;
import com.sda.group11.jalex.projectmanagement.model.Project;
import com.sda.group11.jalex.projectmanagement.repositories.ProjectRepository;
import com.sda.group11.jalex.projectmanagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sda.group11.jalex.projectmanagement.controller.ProjectResources.API_PROJECTS;

@RestController
@RequestMapping(path = API_PROJECTS)
public class ProjectResources {
    public static final String API_PROJECTS = "/api/projects";

    private final ProjectService projectService;
    private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;


    @Autowired
    public ProjectResources(ProjectService projectService, ProjectMapper projectMapper, ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> findAll() {
        List<Project> allProjects = projectService.findAll();
        List<ProjectResponse> allProjectsToDto = projectMapper.toDto(allProjects);
        return new ResponseEntity<>(allProjectsToDto, HttpStatus.OK);
    }

    @GetMapping(("/{id}"))
    public ResponseEntity<ProjectResponse> getProjectsById(@PathVariable Long id){
        Project project = projectService.getProjectById(id);
        ProjectResponse projectByIdToDto = projectMapper.toDto(project);
        return new ResponseEntity<>(projectByIdToDto, HttpStatus.OK);
    }

    // create
    @PostMapping
    public ResponseEntity<ProjectResponse> save(@RequestBody ProjectRequest request) {
        Project project = projectMapper.toEntity(request);
        Project savedProject = projectService.save(project);
        ProjectResponse projectResponse = projectMapper.toDto(savedProject);
        return new ResponseEntity<>(projectResponse, HttpStatus.CREATED);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> update(@PathVariable(name = "id") Long id,
                                               @RequestBody ProjectRequest request) {
        Project project = projectMapper.toEntity(request);
        Project updatedProject = projectService.update(id, project);
        ProjectResponse projectResponse = projectMapper.toDto(updatedProject);
        return new ResponseEntity<>(projectResponse, HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        projectService.delete(id);
        return new ResponseEntity<>("project deleted", HttpStatus.OK);
    }

}
