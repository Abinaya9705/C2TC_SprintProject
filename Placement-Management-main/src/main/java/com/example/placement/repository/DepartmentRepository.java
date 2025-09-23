package com.example.placement.repository;

import com.example.placement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByCollegeId(Long collegeId);
    List<Department> findByCollegeIdOrderByNameAsc(Long collegeId);
}
