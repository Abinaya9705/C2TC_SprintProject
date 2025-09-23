package com.example.placement.controller;

import com.example.placement.dto.CollegeSignupRequest;
import com.example.placement.model.Batch;
import com.example.placement.model.College;
import com.example.placement.model.Department;
import com.example.placement.repository.CollegeRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/colleges")
public class CollegeController {
    private final CollegeRepository collegeRepository;

    public CollegeController(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    @GetMapping("/signup")
    public String collegeSignupForm(Model model) {
        model.addAttribute("collegeRequest", new CollegeSignupRequest());
        return "college-signup";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<College> createCollege(@Valid @RequestBody CollegeSignupRequest request) {
        College college = new College();
        college.setName(request.getCollegeName());

        for (CollegeSignupRequest.DepartmentDTO dDto : request.getDepartments()) {
            Department dept = new Department();
            dept.setName(dDto.getName());
            dept.setCollege(college);
            college.getDepartments().add(dept);

            for (CollegeSignupRequest.BatchDTO bDto : dDto.getBatches()) {
                Batch batch = new Batch();
                batch.setStartYear(bDto.getStartYear());
                batch.setEndYear(bDto.getEndYear());
                batch.setDepartment(dept);
                dept.getBatches().add(batch);
            }
        }
        College saved = collegeRepository.save(college);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<College> listColleges() {
        return collegeRepository.findAll();
    }
}
