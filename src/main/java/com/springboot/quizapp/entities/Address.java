package com.springboot.quizapp.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private int houseNumber;
	private String street;
	private String city;
	private int pinCode;

	@OneToMany(mappedBy = "add", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<User> user;

}
