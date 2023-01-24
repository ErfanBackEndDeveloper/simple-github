package com.example.simple_github.repository;

import com.example.simple_github.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProjectRepo extends JpaRepository<Project, Long> {

    @Modifying
    @Query("update Project pro set pro.title = :title ,pro.description = :description  where pro.id = :id")
    void updateByProjectId(String title, String description, Long id);

}
