package com.pm.patientmanagement.Service;

import com.pm.patientmanagement.Exception.EmailAlreadyExists;
import com.pm.patientmanagement.Exception.PatientNotFoundException;
import com.pm.patientmanagement.PatientMapper.PAtientMapping;
import com.pm.patientmanagement.Repo.PatientRepo;
import com.pm.patientmanagement.dto.PatientCreateDto;
import com.pm.patientmanagement.dto.PatientResponseDTO;
import com.pm.patientmanagement.dto.PatientUpdateDto;
import com.pm.patientmanagement.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private PatientRepo PatientRepo;
    public PatientService(PatientRepo patientRepo) {
        PatientRepo = patientRepo;
    }

    public List<PatientResponseDTO> getPatients (){
        List<Patient> patients = PatientRepo.findAll();
        //patients.stream().forEach(item -> System.out.println(item));
        List<PatientResponseDTO> responseDTOS = patients.stream().map(p->PAtientMapping.dto(p)).toList();
        return responseDTOS;
    }

    public PatientResponseDTO createPatient(PatientCreateDto patientCreateDto){

        if (PatientRepo.existsByEmail(patientCreateDto.getEmail())){
            throw new EmailAlreadyExists("3This Email already exists: "+ patientCreateDto.getEmail());
        }

        Patient patient =  PatientRepo.save(PAtientMapping.toPatient(patientCreateDto));

        PatientResponseDTO dto = PAtientMapping.dto(patient);
        return dto;
    }

    public PatientResponseDTO updatePatient(UUID id, PatientUpdateDto patientUpdateDto){
        Patient patient = PatientRepo.findById(id).orElseThrow(() -> new PatientNotFoundException("No Patient exists for UUID: "+id));

        if (patientUpdateDto.getName() != null && !patientUpdateDto.getName().isBlank()){
            patient.setName(patientUpdateDto.getName());
        }
        if (patientUpdateDto.getEmail() != null && !patientUpdateDto.getEmail().isBlank()){
            if (PatientRepo.existsByEmailAndIdNot(patientUpdateDto.getEmail(), id)){
                throw new EmailAlreadyExists("This Email already exists: "+ patientUpdateDto.getEmail());
            }
            patient.setEmail(patientUpdateDto.getEmail());
        }
        if (patientUpdateDto.getAddr() != null && !patientUpdateDto.getAddr().isBlank()){
            patient.setAddress(patientUpdateDto.getAddr());
        }
        if (patientUpdateDto.getDOB() != null && !patientUpdateDto.getDOB().isBlank()){
            patient.setDateofBirth(LocalDate.parse(patientUpdateDto.getDOB()));
        }


        patient =  PatientRepo.save(patient);
        PatientResponseDTO dto = PAtientMapping.dto(patient);
        return dto;

    }

    public void deletepatient(UUID id){
        if (!PatientRepo.existsById(id)) {
            throw new PatientNotFoundException("Patient not found: " + id);
        }
        PatientRepo.deleteById(id);
    }

}
