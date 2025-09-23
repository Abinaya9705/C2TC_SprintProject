package com.example.placement.controller;

import com.example.placement.model.College;
import com.example.placement.model.Department;
import com.example.placement.model.Batch;
import com.example.placement.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BrowseController {
    private final CollegeRepository collegeRepository;
    private final DepartmentRepository departmentRepository;
    private final BatchRepository batchRepository;
    private final StudentRepository studentRepository;

    public BrowseController(CollegeRepository collegeRepository, DepartmentRepository departmentRepository, BatchRepository batchRepository, StudentRepository studentRepository) {
        this.collegeRepository = collegeRepository;
        this.departmentRepository = departmentRepository;
        this.batchRepository = batchRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/colleges")
    public String listColleges(Model model) {
        List<College> colleges = collegeRepository.findAll();
        model.addAttribute("colleges", colleges);
        return "browse/colleges";
    }

    @GetMapping("/colleges/{collegeId}")
    public String viewCollege(@PathVariable("collegeId") Long collegeId, Model model) {
        College college = collegeRepository.findById(collegeId).orElse(null);
        if (college == null) return "redirect:/colleges";
        List<Department> departments = departmentRepository.findByCollegeIdOrderByNameAsc(collegeId);
        model.addAttribute("college", college);
        model.addAttribute("departments", departments);
        return "browse/college-detail";
    }

    @GetMapping("/departments/{deptId}")
    public String viewDepartment(@PathVariable("deptId") Long deptId, Model model) {
        Department dept = departmentRepository.findById(deptId).orElse(null);
        if (dept == null) return "redirect:/colleges";
        List<Batch> batches = batchRepository.findByDepartmentId(deptId);
        model.addAttribute("department", dept);
        model.addAttribute("batches", batches);
        return "browse/department-detail";
    }

    @GetMapping("/batches/{batchId}")
    public String viewBatch(@PathVariable("batchId") Long batchId, Model model) {
        Batch batch = batchRepository.findById(batchId).orElse(null);
        if (batch == null) return "redirect:/colleges";
        model.addAttribute("batch", batch);
        model.addAttribute("students", studentRepository.findByBatchId(batchId));
        return "browse/batch-detail";
    }
}
