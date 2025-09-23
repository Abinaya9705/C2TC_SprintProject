package com.example.placement.repository;

import com.example.placement.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, Long> {
    List<Batch> findByDepartmentId(Long departmentId);
}
