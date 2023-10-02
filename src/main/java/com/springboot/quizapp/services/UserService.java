package com.springboot.quizapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.quizapp.dao.AddressDao;
import com.springboot.quizapp.dao.UserDao;
import com.springboot.quizapp.entities.Address;
import com.springboot.quizapp.entities.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	AddressDao addressDao;

	public ResponseEntity<User> addUser(User user) {

		Address existingAddress = addressDao.findByHouseNumberCityAndPinCode(user.getAdd().getHouseNumber(),
				user.getAdd().getCity(), user.getAdd().getPinCode());

		User u = new User();
		u.setFName(user.getFName());
		u.setLName(user.getLName());
		u.setQuizId(user.getQuizId());
		u.setMobile(user.getMobile());

		if (existingAddress != null) {
			u.setAdd(existingAddress);
		} else {
			Address newAddress = new Address();
			newAddress.setHouseNumber(user.getAdd().getHouseNumber());
			newAddress.setCity(user.getAdd().getCity());
			newAddress.setPinCode(user.getAdd().getPinCode());
			newAddress.setStreet(user.getAdd().getStreet());
			addressDao.save(newAddress);
			u.setAdd(newAddress);

		}

		userDao.save(u);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
