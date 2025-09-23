package com.example.placement.config;

import com.example.placement.model.*;
import com.example.placement.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner seed(CollegeRepository colleges, DepartmentRepository departments, BatchRepository batches, StudentRepository students) {
        return args -> {
            if (colleges.count() > 0) return;

            College c1 = new College();
            c1.setName("Greenfield Institute of Technology");

            Department d1 = new Department(); d1.setName("Computer Science"); d1.setCollege(c1); c1.getDepartments().add(d1);
            Department d2 = new Department(); d2.setName("Electronics"); d2.setCollege(c1); c1.getDepartments().add(d2);

            Batch b11 = new Batch(); b11.setStartYear(2022); b11.setEndYear(2026); b11.setDepartment(d1); d1.getBatches().add(b11);
            Batch b12 = new Batch(); b12.setStartYear(2023); b12.setEndYear(2027); b12.setDepartment(d1); d1.getBatches().add(b12);
            Batch b21 = new Batch(); b21.setStartYear(2021); b21.setEndYear(2025); b21.setDepartment(d2); d2.getBatches().add(b21);

            College c2 = new College();
            c2.setName("Riverview College");
            Department d3 = new Department(); d3.setName("Mechanical"); d3.setCollege(c2); c2.getDepartments().add(d3);
            Batch b31 = new Batch(); b31.setStartYear(2020); b31.setEndYear(2024); b31.setDepartment(d3); d3.getBatches().add(b31);

            colleges.save(c1);
            colleges.save(c2);

            // Add a couple of students (set required phone and some optional fields)
            Student s1 = new Student();
            s1.setFullName("Asha Raman");
            s1.setEmail("asha@example.com");
            s1.setPhone("+1-555-0101");
            s1.setGraduationYear(2027);
            s1.setCgpa(8.5);
            s1.setSkills("Java, Spring, SQL");
            s1.setCollege(c1); s1.setDepartment(d1); s1.setBatch(b12);

            Student s2 = new Student();
            s2.setFullName("Kiran Das");
            s2.setEmail("kiran@example.com");
            s2.setPhone("+1-555-0102");
            s2.setGraduationYear(2025);
            s2.setCgpa(8.0);
            s2.setSkills("Electronics, Embedded, C");
            s2.setCollege(c1); s2.setDepartment(d2); s2.setBatch(b21);

            students.save(s1); students.save(s2);
        };
    }
}
