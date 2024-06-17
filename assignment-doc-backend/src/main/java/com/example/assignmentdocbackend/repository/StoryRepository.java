package com.example.assignmentdocbackend.repository;

import com.example.assignmentdocbackend.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Integer> {
    @Query("SELECT s FROM Story s WHERE s.department.id = :departmentId")
    List<Story> findByDepartmentId(@Param("departmentId") int departmentId);
}