package com.pm.patientmanagement.PatientMapper;

import com.pm.patientmanagement.dto.PatientCreateDto;
import com.pm.patientmanagement.dto.PatientResponseDTO;
import com.pm.patientmanagement.model.Patient;

import java.time.LocalDate;

public class PAtientMapping {
    public static PatientResponseDTO dto(Patient patient){
        PatientResponseDTO Dto = new PatientResponseDTO();
        Dto.setId(patient.getId().toString());
        Dto.setName(patient.getName());
        Dto.setEmail(patient.getEmail());
        Dto.setAddr(patient.getAddress());
        Dto.setDOB(patient.getDateofBirth().toString());
        Dto.setRegDate(patient.getRegisteredDate().toString());

        return Dto;
    }

    public static Patient toPatient(PatientCreateDto patientCreateDto){
        Patient patient = new Patient();
        patient.setName(patientCreateDto.getName());
        patient.setEmail(patientCreateDto.getEmail());
        patient.setAddress(patientCreateDto.getAddr());
        patient.setDateofBirth(LocalDate.parse(patientCreateDto.getDob()));
        patient.setRegisteredDate(LocalDate.now());

        return patient;
    }

}
