package com.masai.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(DoctorException.class)
	public ResponseEntity<ErrorHandle> doctorExceptionHandler(DoctorException de, WebRequest req){
		
		
		ErrorHandle err= new ErrorHandle();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(de.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<ErrorHandle>(err, HttpStatus.BAD_GATEWAY);
		
	}
	@ExceptionHandler(PatientException.class)
	public ResponseEntity<ErrorHandle> patientExceptionHandler(PatientException pe, WebRequest req){
		
		
		ErrorHandle err= new ErrorHandle();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(pe.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<ErrorHandle>(err, HttpStatus.BAD_GATEWAY);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArguExceptionHandler(MethodArgumentNotValidException e){
		
		Map<String, String> resp=new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error)->{
			String fielName=((FieldError)error).getField();
			String message= error.getDefaultMessage();
			resp.put(fielName, message);
		});
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorHandle> dataIntegrityViolationExceptionHandler(DataIntegrityViolationException ex ,WebRequest we){
		
		
		ErrorHandle err= new ErrorHandle();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage("Phone Number Already Exist");
			err.setDetails(we.getDescription(false));
				
		return new ResponseEntity<ErrorHandle>(err, HttpStatus.BAD_GATEWAY);
		
	
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorHandle> ExceptionHandler(Exception ex, WebRequest req){
		
		
		ErrorHandle error= new ErrorHandle();
			error.setTimestamp(LocalDateTime.now());
			error.setMessage(ex.getMessage());
			error.setDetails(req.getDescription(false));
				
		return new ResponseEntity<ErrorHandle>(error, HttpStatus.BAD_GATEWAY);
		
	}
	
	
}