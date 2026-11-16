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

import com.vcube.hospitalmanagementsystem.Repo.DoctorRepo;
import com.vcube.hospitalmanagementsystem.model.Doctor;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepo doctorRepository;

    // 1. Add Doctor
    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // 2. Get All Doctors
    @GetMapping("/getAllDoctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // 3. Get Doctor By ID
    @GetMapping("/getDoctor/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {

        return doctorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. Search Doctor By First Name
    @GetMapping("/getDoctor/name/{firstName}")
    public List<Doctor> getDoctorByName(@PathVariable String firstName) {
        return doctorRepository.findByFirstName(firstName);
    }

    // 5. Search Doctor By Specialization
    @GetMapping("/getDoctor/specialization/{specialization}")
    public List<Doctor> getDoctorBySpecialization(
            @PathVariable String specialization) {

        return doctorRepository.findBySpecialization(specialization);
    }

    // 6. Update Doctor
    @PutMapping("/update/{id}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable Long id,
            @RequestBody Doctor doctor) {

        return doctorRepository.findById(id)
                .map(existingDoctor -> {

                    existingDoctor.setFirstName(doctor.getFirstName());
                    existingDoctor.setLastName(doctor.getLastName());
                    existingDoctor.setSpecialization(doctor.getSpecialization());
                    existingDoctor.setPhone(doctor.getPhone());
                    existingDoctor.setEmail(doctor.getEmail());
                    existingDoctor.setExperience(doctor.getExperience());
                    existingDoctor.setDepartmentId(doctor.getDepartmentId());

                    Doctor updatedDoctor =
                            doctorRepository.save(existingDoctor);

                    return ResponseEntity.ok(updatedDoctor);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 7. Delete Doctor
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {

        if (!doctorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        doctorRepository.deleteById(id);

        return ResponseEntity.ok("Doctor deleted successfully");
    }
}

	
	
	
