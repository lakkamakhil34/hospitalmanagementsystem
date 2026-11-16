package com.vcube.hospitalmanagementsystem.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vcube.hospitalmanagementsystem.Repo.PatientRepo;
import com.vcube.hospitalmanagementsystem.model.Patient;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepo patientRepository;

    // 1. Add Patient
    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    // 2. Get All Patients
    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // 3. Get Patient By ID
    @GetMapping("/getPatient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {

        return patientRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. Get Patient By First Name
    @GetMapping("/getPatient/name/{firstName}")
    public List<Patient> getPatientByName(@PathVariable String firstName) {
        return patientRepository.findByFirstName(firstName);
    }

    // 5. Update Patient
    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable Long id,
            @RequestBody Patient patient) {

        return patientRepository.findById(id)
                .map(existingPatient -> {

                    existingPatient.setFirstName(patient.getFirstName());
                    existingPatient.setLastName(patient.getLastName());
                    existingPatient.setAge(patient.getAge());
                    existingPatient.setGender(patient.getGender());
                    existingPatient.setPhone(patient.getPhone());
                    existingPatient.setEmail(patient.getEmail());
                    existingPatient.setAddress(patient.getAddress());
                    existingPatient.setBloodGroup(patient.getBloodGroup());

                    Patient updatedPatient =
                            patientRepository.save(existingPatient);

                    return ResponseEntity.ok(updatedPatient);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 6. Delete Patient
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {

        if (!patientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        patientRepository.deleteById(id);

        return ResponseEntity.ok("Patient deleted successfully");
    }
}

	
