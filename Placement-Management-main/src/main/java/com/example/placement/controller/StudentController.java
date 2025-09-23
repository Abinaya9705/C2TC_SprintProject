package com.example.placement.controller;

import com.example.placement.model.*;
import com.example.placement.repository.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentController {
    private final StudentRepository studentRepository;
    private final CollegeRepository collegeRepository;
    private final DepartmentRepository departmentRepository;
    private final BatchRepository batchRepository;

    public StudentController(StudentRepository studentRepository,
                             CollegeRepository collegeRepository,
                             DepartmentRepository departmentRepository,
                             BatchRepository batchRepository) {
        this.studentRepository = studentRepository;
        this.collegeRepository = collegeRepository;
        this.departmentRepository = departmentRepository;
        this.batchRepository = batchRepository;
    }

    @GetMapping("/students/signup")
    public String studentSignup(Model model) {
        Student s = new Student();
        s.setCollege(new College());
        s.setDepartment(new Department());
        s.setBatch(new Batch());
        model.addAttribute("student", s);
        model.addAttribute("colleges", collegeRepository.findAll());
        return "student-signup";
    }

    @PostMapping("/students")
    public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("colleges", collegeRepository.findAll());
            return "student-signup";
        }
        Long collegeId = student.getCollege() != null ? student.getCollege().getId() : null;
        Long deptId = student.getDepartment() != null ? student.getDepartment().getId() : null;
        Long batchId = student.getBatch() != null ? student.getBatch().getId() : null;
        if (collegeId == null || deptId == null || batchId == null) {
            bindingResult.reject("invalid.selection", "Please select college, department, and batch");
            model.addAttribute("colleges", collegeRepository.findAll());
            return "student-signup";
        }
        College college = collegeRepository.findById(collegeId).orElse(null);
        Department department = departmentRepository.findById(deptId).orElse(null);
        Batch batch = batchRepository.findById(batchId).orElse(null);
        if (college == null || department == null || batch == null) {
            bindingResult.reject("invalid.selection", "Invalid selections");
            model.addAttribute("colleges", collegeRepository.findAll());
            return "student-signup";
        }
        student.setCollege(college);
        student.setDepartment(department);
        student.setBatch(batch);

        studentRepository.save(student);
        return "redirect:/students/signup?success";
    }

    @GetMapping("/students/{id:\\d+}")
    public String viewStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return "redirect:/colleges";
        }
        model.addAttribute("student", student);
        return "browse/student-detail";
    }
}
