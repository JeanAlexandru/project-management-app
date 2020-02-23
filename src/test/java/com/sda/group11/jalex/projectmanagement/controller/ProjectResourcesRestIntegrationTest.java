package com.sda.group11.jalex.projectmanagement.controller;

import com.sda.group11.jalex.projectmanagement.RestIntegrationTest;
import com.sda.group11.jalex.projectmanagement.dto.ProjectMapper;
import com.sda.group11.jalex.projectmanagement.dto.ProjectRequest;
import com.sda.group11.jalex.projectmanagement.dto.ProjectResponse;
import com.sda.group11.jalex.projectmanagement.model.Project;
import com.sda.group11.jalex.projectmanagement.model.User;
import com.sda.group11.jalex.projectmanagement.repositories.ProjectRepository;
import com.sda.group11.jalex.projectmanagement.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class ProjectResourcesRestIntegrationTest extends RestIntegrationTest {

    @Autowired
    ProjectRepository repository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    ProjectMapper projectMapper;

    @Test
    public void givenExistingProject_whenGetProjectById_thenReturnProject(){
        // GIVEN
        User expectedUser = new User();
        expectedUser.setUserName("Giani");
        expectedUser = userRepository.save(expectedUser);
        Project expectedProject = new Project();
        expectedProject.setName("Matinal");
        expectedProject.setDescription("Matinal tare");
        expectedProject.setUser(expectedUser);
        expectedProject = repository.save(expectedProject);
        ProjectResponse expectedResult = projectMapper.toDto(expectedProject);
        // WHEN
        ResponseEntity<ProjectResponse> actualResponse = restTemplate.getForEntity(url(ProjectResources.API_PROJECTS + "/" + expectedProject.getId()), ProjectResponse.class);
        // THEN
        assertThat(actualResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualResponse.getBody()).isEqualTo(expectedResult);

    }

    @Test
    public void givenExistingUser_whenProjectSaveIsCalled_thenProjectIsSavedCorrectly(){
        // GIVEN
        User expectedUser = new User();
        expectedUser.setUserName("Giani");
        expectedUser = userRepository.save(expectedUser);
        ProjectRequest projectRequest = new ProjectRequest();
        projectRequest.setUserId(expectedUser.getId());
        projectRequest.setName("FirstRun");
        projectRequest.setDescription("DollarBill");
        // WHEN
        ResponseEntity<ProjectResponse> response =
                restTemplate.postForEntity(url(ProjectResources.API_PROJECTS), projectRequest, ProjectResponse.class);
        // THEN
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo(projectRequest.getName());
        assertThat(response.getBody().getDescription()).isEqualTo(projectRequest.getDescription());
        // verify existing user
    }


}