package com.example.simple_github.controller;

import com.example.simple_github.dto.ProjectDto;
import com.example.simple_github.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @PostMapping
    public ResponseEntity<ProjectDto> save(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok().body(projectService.save(projectDto));
    }



    @PutMapping
    public ResponseEntity<ProjectDto> update(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok().body(projectService.updateByPersonId(projectDto));
    }

}
