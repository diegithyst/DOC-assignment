package com.example.assignmentdocbackend.service;

import com.example.assignmentdocbackend.model.Department;
import com.example.assignmentdocbackend.repository.DepartmentRepository;
import com.example.assignmentdocbackend.repository.StoryRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    StoryRepository storyRepository;

    @PostConstruct
    public void init() {
        if (departmentRepository.count() == 0) {
            Department d1 = new Department("Engineering");
            Department d2 = new Department("Marketing");
            Department d3 = new Department("Business");

            departmentRepository.save(d1);
            departmentRepository.save(d2);
            departmentRepository.save(d3);

            System.out.println("Default departments initialized.");
        }
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartment(int departmentId) {
        Department temp = null;
        try {
            temp = departmentRepository.findById(departmentId).get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(int departmentId, Department updatedDepartment) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            department.setName(updatedDepartment.getName());
            return departmentRepository.save(department);
        }
        return null;
    }

    public void deleteDepartment(int departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}