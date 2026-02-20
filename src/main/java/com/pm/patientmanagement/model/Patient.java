package com.pm.patientmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Patient {

    @Id //Denotes Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO) //For auto generated values
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String address;

    @NotNull
    @Column(name = "date_of_birth")
    private LocalDate DateofBirth;

    @NotNull
    private LocalDate RegisteredDate;


    public Patient(){

    }

    public Patient(UUID id, String name, String email, String address, LocalDate dateofBirth, LocalDate registeredDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        DateofBirth = dateofBirth;
        RegisteredDate = registeredDate;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        DateofBirth = dateofBirth;
    }

    public LocalDate getRegisteredDate() {
        return RegisteredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        RegisteredDate = registeredDate;
    }
}
