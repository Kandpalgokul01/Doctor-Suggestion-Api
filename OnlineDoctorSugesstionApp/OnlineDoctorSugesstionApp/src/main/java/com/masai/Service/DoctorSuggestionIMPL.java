package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.DoctorRepo;
import com.masai.Repository.PatientRepo;
import com.masai.exception.DoctorException;
import com.masai.exception.PatientException;
import com.masai.model.Doctor;
import com.masai.model.Patient;
@Service
public class DoctorSuggestionIMPL implements DoctorSuggestion{

	@Autowired
	private DoctorRepo doctorRepo;
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Override
	public List<Doctor> suggestDoctor(Integer patientId) throws DoctorException, PatientException{
        
	    Patient patient = patientRepo.findById(patientId).orElse(null);
        if (patient == null) {
            throw new PatientException("Patient not found");
        }
        String patientCity = patient.getCity();
        String symptom = patient.getSymptom();

        List<Doctor> allDoctors = doctorRepo.findAll();
        List<Doctor> doctorsByLocation = filterDoctorsByLocation(allDoctors, patientCity);
        List<Doctor> doctorsBySpecialty = filterDoctorsBySpecialty(doctorsByLocation, symptom);

        if (doctorsByLocation.isEmpty()) {
            throw new DoctorException("We are still waiting to expand to your location");
        } else if (doctorsBySpecialty.isEmpty()) {
            throw new DoctorException("There isn't any doctor present at your location for your symptom");
        }

        return doctorsBySpecialty;
	} 

	
	 private List<Doctor> filterDoctorsByLocation(List<Doctor> doctors, String location) {
	        return doctors.stream().filter(d -> d.getCity().name().equalsIgnoreCase(location)).collect(Collectors.toList());
	    }
	 
	private List<Doctor> filterDoctorsBySpecialty(List<Doctor> doctors, String symptom) {
	    List<Doctor> filteredDoctors;
	    switch (symptom) {
	        case "Arthritis":
	        case "Backpain":
	        case "Tissue injuries":
	            filteredDoctors = doctors.stream().filter(d -> d.getSpeciality().name().equals("Orthopedic")).collect(Collectors.toList());
	            break;
	        case "Dysmenorrhea":
	            filteredDoctors = doctors.stream().filter(d -> d.getSpeciality().name().equals("Gynecology")).collect(Collectors.toList());
	            break;
	        case "Skin infection":
	        case "Skin burn":
	            filteredDoctors = doctors.stream().filter(d -> d.getSpeciality().name().equals("Dermatology")).collect(Collectors.toList());
	            break;
	        case "Ear pain":
	            filteredDoctors = doctors.stream().filter(d -> d.getSpeciality().name().equals("ENT specialist")).collect(Collectors.toList());
	            break;
	        default:
	            filteredDoctors = new ArrayList<>();
	            break;
	    }
	    return filteredDoctors;
	}

}
