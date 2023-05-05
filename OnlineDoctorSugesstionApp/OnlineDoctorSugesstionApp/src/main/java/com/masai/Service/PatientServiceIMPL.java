package com.masai.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.PatientRepo;
import com.masai.exception.PatientException;
import com.masai.model.Patient;

@Service
public class PatientServiceIMPL implements PatientService {

	@Autowired
	private PatientRepo patientRepo;
	
	
	
	@Override
	public Patient addPatient(Patient patient) {
		
		return patientRepo.save(patient);
	}

	@Override
	public String removePateint(Integer id) throws PatientException {
		Optional<Patient> patient=patientRepo.findById(id);
		if(!patient.isPresent()) throw new PatientException("No Patient Found");
		else {
			patientRepo.delete(patient.get());
			return "Patient removed from the system";
		}
			
	}

}
