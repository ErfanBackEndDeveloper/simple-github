package com.example.simple_github.dto;

import com.example.simple_github.entity.Person;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectDtoForPerson {

    private Long id;

    private String title;

    private String description;

}


