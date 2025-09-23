package com.example.placement.controller;

import com.example.placement.model.Batch;
import com.example.placement.model.Department;
import com.example.placement.repository.BatchRepository;
import com.example.placement.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LookupController {
    private final DepartmentRepository departmentRepository;
    private final BatchRepository batchRepository;

    public LookupController(DepartmentRepository departmentRepository, BatchRepository batchRepository) {
        this.departmentRepository = departmentRepository;
        this.batchRepository = batchRepository;
    }

    @GetMapping("/colleges/{collegeId}/departments")
    public List<Department> getDepartments(@PathVariable("collegeId") Long collegeId) {
        return departmentRepository.findByCollegeId(collegeId);
    }

    @GetMapping("/departments/{deptId}/batches")
    public List<Batch> getBatches(@PathVariable("deptId") Long deptId) {
        return batchRepository.findByDepartmentId(deptId);
    }
}
