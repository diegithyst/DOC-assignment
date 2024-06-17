package com.example.assignmentdocbackend.service;

import com.example.assignmentdocbackend.model.Department;
import com.example.assignmentdocbackend.repository.DepartmentRepository;
import com.example.assignmentdocbackend.repository.StoryRepository;
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