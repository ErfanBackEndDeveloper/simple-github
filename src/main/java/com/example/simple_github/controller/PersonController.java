package com.example.simple_github.controller;

import com.example.simple_github.dto.Person2ProjectDto;
import com.example.simple_github.dto.PersonDto;
import com.example.simple_github.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> save(@RequestBody PersonDto personDto) {
        PersonDto save = personService.save(personDto);
        return ResponseEntity.ok().body(save);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @PutMapping
    public ResponseEntity<PersonDto> update(@RequestBody PersonDto personUpdateDto ){
        return ResponseEntity.ok().body(personService.updateByPersonId(personUpdateDto));
    }


    @PutMapping("/updatePerson2Project")
    public ResponseEntity<Person2ProjectDto> updatePersonProject(@RequestBody Person2ProjectDto person2ProjectDto){
        personService.updatePersonProject(person2ProjectDto);
        return ResponseEntity.ok().body(person2ProjectDto);
    }


    @PostMapping("/savePerson2Project")
    public ResponseEntity<Person2ProjectDto> savePersonProject(@RequestBody Person2ProjectDto person2ProjectDto){
         personService.savePersonProject(person2ProjectDto);
        return ResponseEntity.ok().body(person2ProjectDto);
    }



}



// "projects":[{
//     "title":"project",
//     "description":"sldflsmf;lsfssf  sfjlskjflsjfls"
// }]