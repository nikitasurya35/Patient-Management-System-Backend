package com.pm.patientmanagement.controller;

import com.pm.patientmanagement.Service.PatientService;
import com.pm.patientmanagement.dto.PatientCreateDto;
import com.pm.patientmanagement.dto.PatientResponseDTO;
import com.pm.patientmanagement.dto.PatientUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name="PatientManagement", description = "APIs for PatientManagementSystem")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get All Patients")
    public ResponseEntity<List<PatientResponseDTO>> showPatients(){
        List<PatientResponseDTO> patientServ = patientService.getPatients();
        return ResponseEntity.ok().body(patientServ);
    }

    @PostMapping
    @Operation(summary = "Create New Patient")
    public ResponseEntity<PatientResponseDTO> createPatients(@Valid @RequestBody PatientCreateDto patientCreateDto){
        //System.out.println(patientCreateDto);
        System.out.println("ans:::: " +patientCreateDto.getDob());
        PatientResponseDTO dts = patientService.createPatient(patientCreateDto);
        return ResponseEntity.ok().body(dts);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Patient values")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id, @RequestBody PatientUpdateDto patientUpdateDto){
        PatientResponseDTO responseDTO = patientService.updatePatient(id, patientUpdateDto);
        return ResponseEntity.ok().body(responseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Patient")
     public ResponseEntity<String> deletePatient(@PathVariable UUID id){
        patientService.deletepatient(id);
        return ResponseEntity.ok("Deletion is Successfull!!");
    }
}
