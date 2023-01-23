package com.example.simple_github.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

//    @ManyToOne(cascade = { CascadeType.MERGE},fetch = FetchType.LAZY)
//    private Person person ;

}
