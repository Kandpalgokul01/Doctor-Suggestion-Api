package com.masai.Service;

import java.util.List;

import com.masai.exception.DoctorException;
import com.masai.exception.PatientException;
import com.masai.model.Doctor;

public interface DoctorSuggestion {

	List<Doctor> suggestDoctor(Integer patientId)throws DoctorException,PatientException ;
	
}
