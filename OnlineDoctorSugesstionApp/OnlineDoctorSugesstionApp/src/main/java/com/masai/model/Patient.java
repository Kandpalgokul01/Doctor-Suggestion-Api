package com.masai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Patient {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patientId;
	

	
	@NotNull(message = "Name is mandatory")
	 @Size(min = 3, message = "Name should have at least 3 characters")
	private String name;
	 
	 @NotNull(message = "City is mandatory")
	 @Size(max =20 , message = "City should be at max 20 characters)")
	private String city;
	

   @NotNull(message = "Email is mandatory")
   @Email(message = "Please provide a valid email address")
	private String email;
	
   @NotNull(message = "Phone number is mandatory")
   @Size(min = 10, message = "Phone number should have at least 10 digits")
   @Column(unique = true)
	private String phoneNumber;
	
//	@Enumerated(EnumType.STRING)
	@NotNull(message="Symptom is mandatory")
	private String symptom;
	
}
