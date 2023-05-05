package com.masai.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.PatientService;
import com.masai.exception.PatientException;
import com.masai.model.Patient;

@RestController
@RequestMapping("/Patient/")
public class PatientController {


	@Autowired
    private PatientService patientService;
	
	@PostMapping("")
	public ResponseEntity<Patient> addPatientHandler(@Valid @RequestBody Patient patient) throws PatientException{
		
		
		return new ResponseEntity<Patient>(patientService.addPatient(patient), HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePatientHandler(@PathVariable Integer id ) throws PatientException{
		String resp=patientService.removePateint(id);
		
		return new ResponseEntity<String>(resp, HttpStatus.OK);
		
		
	}
	
	
}
