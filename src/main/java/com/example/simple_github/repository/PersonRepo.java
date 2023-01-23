package com.example.simple_github.repository;

import com.example.simple_github.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
@Transactional
public interface PersonRepo extends JpaRepository<Person, Long> {
    @Modifying
    @Query("update Person p set p.firstName =?1 ,p.lastName =?2 ,p.registerDate =?3 where p.id =?4")
    void updateByPersonId(String firstName, String lastName, Date registerDate, Long personId);

    @Modifying
    @Query(value = "UPDATE github.person_project pp SET pp.project_id = :newProjectId WHERE pp.person_id =:personId AND pp.project_id =:projectId", nativeQuery = true)
    int updatePersonProject(Long newProjectId, Long personId, Long projectId);
}
