package com.graphql.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentRequest {
	
	@GetMapping("/get")
	public StudentResponse getStudent() {
		StudentResponse sres = new StudentResponse(1, "Try", "Error");
		return sres;
		
	}

	
}
