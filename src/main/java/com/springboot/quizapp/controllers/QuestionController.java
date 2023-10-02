package com.springboot.quizapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.quizapp.entities.Question;
import com.springboot.quizapp.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	//Auto-wiring
	@Autowired
	private QuestionService questionService;

	//Get all questions.
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>>  getAllQuestions() {
		return questionService.getAllQuestions();
	}

	// get questions by category.
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
		return questionService.getQuestionsByCategory(category);
	}
	
	//add new questions.
	@PostMapping("/addQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
}
