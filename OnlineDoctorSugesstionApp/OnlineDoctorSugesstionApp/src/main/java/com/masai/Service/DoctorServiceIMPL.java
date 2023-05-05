package com.masai.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.DoctorRepo;
import com.masai.exception.DoctorException;
import com.masai.model.Doctor;
@Service
public class DoctorServiceIMPL implements DoctorService {

	@Autowired
	private DoctorRepo doctorRepo;
	
	
	
	@Override
	public Doctor addDoctor(Doctor doctor){
		return doctorRepo.save(doctor);

	}



	@Override
	public String removeDoctor(Integer id) throws DoctorException {
	Optional<Doctor> doctor	=doctorRepo.findById(id);
	if(!doctor.isPresent()) throw new DoctorException("No Doctor Regiesterd");
	else {
		doctorRepo.delete(doctor.get());
		return "Doctor Removed From the System";
	}
	
		
	}
	

}
