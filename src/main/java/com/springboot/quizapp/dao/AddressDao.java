package com.springboot.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.quizapp.entities.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Long> {

	
	@Query(nativeQuery = true,value = "SELECT * FROM address WHERE house_number = :houseNumber AND city = :city AND pin_code = :pinCode")
	Address findByHouseNumberCityAndPinCode(int houseNumber, String city, int pinCode);
	
}
