package com.example.simple_github.dto;

import com.example.simple_github.entity.Project;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class PersonDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Date registerDate = new Date();

    private List<ProjectDtoForPerson> projects = new ArrayList<>();

}

//"id":""
//
//        {
//        "firstName":"",
//        "lastName":"",
//        "registerDate":"",
//        "projects":""
//        }