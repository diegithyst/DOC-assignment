package com.example.assignmentdocbackend.repository;

import com.example.assignmentdocbackend.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}