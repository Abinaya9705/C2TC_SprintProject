package com.placementmanagement.college;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String aicte;
    private int rank;
    private String cgtype;
    private String website;
    

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getaicte() { return aicte; }
    public void setaicte(String aicte) { this.aicte = aicte; }
    public int getrank() { return rank; }
    public void setrank(int rank) { this.rank = rank; }
    public String getcgtype() { return cgtype; }
    public void setcgtype(String cgtype) { this.cgtype = cgtype; }
    public String getwebsite() { return website; }
    public void setwebsite(String website) { this.website = website; }
    
}
