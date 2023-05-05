package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Patient;

public interface PatientRepo  extends JpaRepository<Patient, Integer>{

}
