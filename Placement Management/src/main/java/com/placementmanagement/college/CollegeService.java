package com.placementmanagement.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;

    public College saveCollege(College college) {
        return collegeRepository.save(college);
    }

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    public Optional<College> getCollegeById(Long id) {
        return collegeRepository.findById(id);
    }

    public College updateCollege(Long id, College collegeDetails) {
        College college = collegeRepository.findById(id).orElseThrow();
        college.setName(collegeDetails.getName());
        college.setAddress(collegeDetails.getAddress());
        college.setEmail(collegeDetails.getEmail());
        college.setPhone(collegeDetails.getPhone());
        college.setaicte(collegeDetails.getaicte());
        college.setrank(collegeDetails.getrank());
        college.setcgtype(collegeDetails.getcgtype());
        college.setwebsite(collegeDetails.getwebsite());
        return collegeRepository.save(college);
    }

    public void deleteCollege(Long id) {
        collegeRepository.deleteById(id);
    }
}
