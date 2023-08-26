package com.mohammadtest.mongoCrud.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Employee {
    @Id
    private String id;
    
    @NotBlank(message = "First name is required")
    private String fname;

    @NotBlank(message = "Last name is required")
    private String lname;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{20}", message = "Phone number must be 10 digits")
    private String phone;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Address is required")
    @Size(max = 100, message = "Address should be maximum 100 characters")
    private String address;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
    
    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
