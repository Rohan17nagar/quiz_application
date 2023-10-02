package com.springboot.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.quizapp.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
}
