package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.DoctorSuggestion;
import com.masai.exception.DoctorException;
import com.masai.exception.PatientException;
import com.masai.model.Doctor;

@RestController
@RequestMapping("/Suggestions/")
public class SuggestionController {

	
	@Autowired
	private DoctorSuggestion doctorSuggestion;
	
   @GetMapping("/{id}")
   
   public ResponseEntity<List<Doctor>> suggestionDoctorHandler(@PathVariable("id") Integer id) throws DoctorException,PatientException{
 		List<Doctor> doctors=doctorSuggestion.suggestDoctor(id);
 		
 		return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
 		
 	}
	
}
