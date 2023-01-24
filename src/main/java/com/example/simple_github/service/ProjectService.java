package com.example.simple_github.service;

import com.example.simple_github.dto.ProjectDto;
import com.example.simple_github.entity.Project;
import com.example.simple_github.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public ProjectDto save(ProjectDto projectDto) {
        Project save = projectRepo.save(convertDtoToEntity(projectDto));
        return convertEntityToDto(save);
    }

    public ProjectDto updateByPersonId(ProjectDto projectDto) {
        Project project = projectRepo.findById(projectDto.getId()).orElseThrow(RuntimeException::new);
        if (projectDto.getTitle() != null) {
            project.setTitle(projectDto.getTitle());
        }
        if (projectDto.getDescription() != null) {
            project.setDescription(projectDto.getDescription());
        }

        projectRepo.updateByProjectId(project.getTitle(), project.getDescription(), project.getId());

        return convertEntityToDto(projectRepo.findById(projectDto.getId()).orElseThrow(RuntimeException::new));

    }


    public ProjectDto convertEntityToDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setDescription(project.getDescription());
        projectDto.setTitle(project.getTitle());
        projectDto.setId(project.getId());
        return projectDto;
    }

    public Project convertDtoToEntity(ProjectDto projectDto) {
        Project project = new Project();
        project.setDescription(projectDto.getDescription());
        project.setTitle(projectDto.getTitle());
        project.setId(projectDto.getId());
        return project;
    }
}
