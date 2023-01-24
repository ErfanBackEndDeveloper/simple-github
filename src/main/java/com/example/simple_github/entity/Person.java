package com.example.simple_github.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Date registerDate;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "person_project",
            joinColumns = {@JoinColumn(name = "person_ID")},
            inverseJoinColumns = {@JoinColumn(name = "project_ID")})
    private List<Project> projects = new ArrayList<>();

}
