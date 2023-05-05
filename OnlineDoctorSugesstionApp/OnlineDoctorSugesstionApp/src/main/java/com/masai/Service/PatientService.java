package com.masai.Service;

import com.masai.exception.PatientException;
import com.masai.model.Patient;

public interface PatientService {

	public Patient addPatient(Patient patient);
	
	public String removePateint(Integer id)throws PatientException;
	
}
