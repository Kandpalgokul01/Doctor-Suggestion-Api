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
public class Doctor {
     
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer doctorId;
	
	  @NotNull(message = "Phone number is mandatory")
	  @Size(min = 10, message = "Phone number should have at least 10 digits")
	  @Column(unique = true)
	private String phoneNumber;
	
	 @NotNull(message = "Name is mandatory")
	 @Size(min = 3, message = "Name should have at least 3 characters")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "City is mandatory")
	private City city;
	
	
    @NotNull(message = "Email is mandatory")
    @Email(message = "Please provide a valid email address")
	private String email;
	
	
	
	@Enumerated(EnumType.STRING)
	@NotNull(message="Speciality is mandatory")
	private Speciality speciality;
	
	
}
