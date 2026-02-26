package com.pm.patientmanagement.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationExcep(MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(e->errors.put(e.getField(), e.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);

    }

    @ExceptionHandler(EmailAlreadyExists.class)
    public ResponseEntity<Map<String,String>> handleEmailDuplicationException(EmailAlreadyExists ex){

        log.warn("2Email Exists {} \n", ex.getMessage());

        Map<String, String> error = new HashMap<>();
        error.put("message", "1This Email Already Exists..Please put a Valid Email");
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String,String>> handlePatientNotFoundException(PatientNotFoundException ex){
        log.warn("No Patient Found: ", ex.getMessage());
        Map<String,String> err = new HashMap<>();
        err.put("message", "No Patient Found. Please try with different ID");
        return ResponseEntity.badRequest().body(err);
    }
}
