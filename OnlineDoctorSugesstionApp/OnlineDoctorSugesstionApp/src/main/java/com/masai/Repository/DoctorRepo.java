package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer>{

	List<Doctor> findByCity(String city);

//	List<Doctor> findByCity(String city);

//	List<Doctor> findByCity(String city);

//	Optional<Doctor> findOne(String phoneNumber);

}
