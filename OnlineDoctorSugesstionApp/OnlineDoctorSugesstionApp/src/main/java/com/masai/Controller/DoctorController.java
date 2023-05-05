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

import com.masai.Service.DoctorService;
import com.masai.exception.DoctorException;
import com.masai.model.Doctor;

@RestController
@RequestMapping("/Doctor/")
public class DoctorController {

	@Autowired
    private DoctorService doctorService;
	
	@PostMapping("")
	public ResponseEntity<Doctor> addDoctorHandler(@Valid @RequestBody Doctor doctor) throws DoctorException{
		
		
		return new ResponseEntity<Doctor>(doctorService.addDoctor(doctor), HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDoctorHandler(@PathVariable Integer id ) throws DoctorException{
		String resp=doctorService.removeDoctor(id);
		
		return new ResponseEntity<String>(resp, HttpStatus.OK);
		
		
	}
	
	
}
