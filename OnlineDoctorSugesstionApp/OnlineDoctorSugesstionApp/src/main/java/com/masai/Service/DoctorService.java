package com.masai.Service;

import com.masai.exception.DoctorException;
import com.masai.model.Doctor;

public interface DoctorService {

	public Doctor addDoctor(Doctor doctor);
	public String removeDoctor(Integer id)throws DoctorException;
}
