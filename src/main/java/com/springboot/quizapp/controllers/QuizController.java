package com.springboot.quizapp.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.quizapp.entities.QuestionWrapper;
import com.springboot.quizapp.entities.Response;
import com.springboot.quizapp.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	//Auto-wiring
	@Autowired
	private QuizService quizService;
	
	//Create quiz.
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ,
			@RequestParam String title) {

		return quizService.createQuiz(category,numQ,title);	
	}
	
	//get quiz by id.
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){

		return quizService.getQuizQuestions(id);
	}
	
	//submit quiz.
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response) {
		
		return quizService.calculateResult(id,response);	
	}	
}
