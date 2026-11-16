package com.vcube.hospitalmanagementsystem.Repo;
	

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.hospitalmanagementsystem.model.Doctor;

@Repository
public interface DoctorRepo  extends JpaRepository<Doctor, Long> {

    List<Doctor> findByFirstName(String firstName);

    List<Doctor> findBySpecialization(String specialization);

}

	
	
	
	


