package com.springboot.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.quizapp.entities.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{
	

}
