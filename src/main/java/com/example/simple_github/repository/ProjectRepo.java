package com.example.simple_github.repository;

import com.example.simple_github.entity.Person;
import com.example.simple_github.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
@Transactional
public interface ProjectRepo extends JpaRepository<Project,Long> {
//    @Transactional
//    @Modifying
//    @Query("update Project p set p.id = ?1 where upper(p.title) = upper(?2) and upper(p.description) = upper(?3)")
//    int updateIdByTitleIgnoreCaseAndDescriptionIgnoreCase(Long id, String title, String description);







//    @Query("update Project pro set pro.title = :title ,pro.description = :description ,pro.person = :person  where pro.id = :id")
    @Modifying
    @Query("update Project pro set pro.title = :title ,pro.description = :description  where pro.id = :id")
    void updateByProjectId(String title , String description , Long id);
//    void updateByProjectId(String title , String description , Person person, Long id);

}
