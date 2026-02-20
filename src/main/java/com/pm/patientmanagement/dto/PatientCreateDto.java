package com.pm.patientmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PatientCreateDto {
    @NotBlank(message = " name is required")
    @Size(max = 100, message = "Canot exceed 100 charactrs")
    private String name;

    @NotBlank(message = "email is required")
    @Email
    private String email;

    @NotBlank(message = "Address is required")
    private String addr;

    @NotBlank(message = "DOB is required")
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private String dob;

    //private String RegistrationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getDob() {
        return dob;
    }

    public void setDOb(String dob) {
        this.dob = dob;
    }

//    public String getRegistrationDate() {
//        return RegistrationDate;
//    }
//
//    public void setRegistrationDate(String registrationDate) {
//        RegistrationDate = registrationDate;
//    }
}
