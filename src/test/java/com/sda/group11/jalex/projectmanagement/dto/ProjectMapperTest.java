package com.sda.group11.jalex.projectmanagement.dto;

import com.sda.group11.jalex.projectmanagement.UnitTest;
import com.sda.group11.jalex.projectmanagement.model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProjectMapperTest extends UnitTest {
    ProjectMapper projectMapper;

    @BeforeEach
    public void before(){
        projectMapper = new ProjectMapper();
    }

    @Test
    void givenProject_whenToDto_thenProjectDtoIsCreatedCorrectly() {
        // GIVEN
        Project project = new Project();
        project.setId(1L);
        project.setName("Manhattan");
        project.setDescription("First project");
        // WHEN
        ProjectResponse restultToDto = projectMapper.toDto(project);
        // THEN
        assertThat(restultToDto.getId()).isEqualTo(project.getId());
        assertThat(restultToDto.getName()).isEqualTo(project.getName());
        assertThat(restultToDto.getDescription()).isEqualTo(project.getDescription());
    }

    @Test
    void testToDto() {
    }

    @Test
    void givenProjectDto_whenToEntity_thenProjectIsCreatedCorrectly() {
        // GIVEN
        ProjectRequest projectRequest = new ProjectRequest();
        projectRequest.setId(2L);
        projectRequest.setName("Mayhem");
        projectRequest.setDescription("Second project");
        // WHEN
        Project result = projectMapper.toEntity(projectRequest);
        // THEN
        assertThat(result.getId()).isEqualTo(projectRequest.getId());
        assertThat(result.getName()).isEqualTo(projectRequest.getName());
        assertThat(result.getDescription()).isEqualTo(projectRequest.getDescription());
    }

    @Test
    void testToEntity() {
    }
}