package com.example.simple_github.service;

import com.example.simple_github.dto.Person2ProjectDto;
import com.example.simple_github.dto.PersonDto;
import com.example.simple_github.dto.ProjectDtoForPerson;
import com.example.simple_github.entity.Person;
import com.example.simple_github.entity.Project;
import com.example.simple_github.repository.PersonRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;


    public PersonDto save(PersonDto personDto) {
        Person save = personRepo.save(converterDtoToEntity(personDto));
        return converterEntityToDto(save);
    }


    @Cacheable("persons")
    public PersonDto findById(Long id) {
        Person person = personRepo.findById(id).orElseGet(Person::new);
        return converterEntityToDto(person);
    }

    public PersonDto updateByPersonId(PersonDto personDto) {
        Person person = personRepo.findById(personDto.getId()).orElseThrow(RuntimeException::new);

        if (personDto.getFirstName() != null) {
            person.setFirstName(personDto.getFirstName());
        }
        if (personDto.getLastName() != null) {
            person.setLastName(personDto.getLastName());
        }
        if (personDto.getRegisterDate() != null) {
            person.setRegisterDate(personDto.getRegisterDate());
        }

        personRepo.updateByPersonId(person.getFirstName(), person.getLastName(), person.getRegisterDate(), person.getId());
        return null;
    }


    public void updatePersonProject(Person2ProjectDto person2ProjectDto) {
        personRepo.updatePersonProject(person2ProjectDto.getNewProjectId(), person2ProjectDto.getPersonId(), person2ProjectDto.getProjectId());
    }

    public void savePersonProject(Person2ProjectDto person2ProjectDto) {
        personRepo.savePersonProject(person2ProjectDto.getPersonId(), person2ProjectDto.getProjectId());
    }


    public Person converterDtoToEntity(PersonDto personDto) {
        List<Project> projects = new ArrayList<>();

        Person person = new Person();
        person.setId(personDto.getId());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setRegisterDate(personDto.getRegisterDate());
        for (ProjectDtoForPerson project :
                personDto.getProjects()) {
            Project newProject = new Project();
            BeanUtils.copyProperties(project, newProject);
            projects.add(newProject);

        }
        person.setProjects(projects);
        return person;
    }


    public PersonDto converterEntityToDto(Person person) {
        List<ProjectDtoForPerson> projectDtoForPerson = new ArrayList<>();

        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setRegisterDate(person.getRegisterDate());
        for (Project project :
                person.getProjects()) {
            ProjectDtoForPerson newProject = new ProjectDtoForPerson();
            BeanUtils.copyProperties(project, newProject);
            projectDtoForPerson.add(newProject);

        }
        personDto.setProjects(projectDtoForPerson);
        return personDto;
    }


}
