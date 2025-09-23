package com.example.placement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.AssertTrue;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1900)
    private int startYear;
    @Min(1900)
    @Max(3000)
    private int endYear;

    @ManyToOne(optional = false)
    @JsonIgnore
    private Department department;

    @AssertTrue(message = "End year must be greater than or equal to start year")
    public boolean isYearRangeValid() {
        // Allow validation to pass when fields are not yet populated in forms
        if (startYear == 0 || endYear == 0) return true;
        return endYear >= startYear;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getStartYear() { return startYear; }
    public void setStartYear(int startYear) { this.startYear = startYear; }
    public int getEndYear() { return endYear; }
    public void setEndYear(int endYear) { this.endYear = endYear; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
