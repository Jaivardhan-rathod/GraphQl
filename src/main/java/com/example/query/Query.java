package com.example.query;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.example.StudentResponse;

@Component
public class Query implements GraphQLQueryResolver  {
	
	public String firstQuery() {
		return "firstQuery";
	}
	
	public String secondQuery() {
		return "SecondQuery";
	}
	
	public String fullName(String fname, String lname) {
		return fname+ " "+lname;
	}
	
	public String fullNameRes(StudentResponse studentResponse) {
		return studentResponse.getFName()+" "+studentResponse.getLName();
	}
	
}
