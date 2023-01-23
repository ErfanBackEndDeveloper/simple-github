package com.example.simple_github.dto;

import com.example.simple_github.entity.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectDto {

    private Long id;

    private String title;

    private String description;

//    private Person person;

}


