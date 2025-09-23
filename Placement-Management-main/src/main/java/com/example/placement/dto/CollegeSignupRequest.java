package com.example.placement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class CollegeSignupRequest {
    @NotBlank
    private String collegeName;

    @NotNull
    private List<DepartmentDTO> departments;

    public static class DepartmentDTO {
        @NotBlank
        private String name;
        @NotNull
        private List<BatchDTO> batches;
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public List<BatchDTO> getBatches() { return batches; }
        public void setBatches(List<BatchDTO> batches) { this.batches = batches; }
    }

    public static class BatchDTO {
        private int startYear;
        private int endYear;
        public int getStartYear() { return startYear; }
        public void setStartYear(int startYear) { this.startYear = startYear; }
        public int getEndYear() { return endYear; }
        public void setEndYear(int endYear) { this.endYear = endYear; }
    }

    public String getCollegeName() { return collegeName; }
    public void setCollegeName(String collegeName) { this.collegeName = collegeName; }
    public List<DepartmentDTO> getDepartments() { return departments; }
    public void setDepartments(List<DepartmentDTO> departments) { this.departments = departments; }
}
