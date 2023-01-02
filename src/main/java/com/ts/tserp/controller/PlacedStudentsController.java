package com.ts.tserp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ts.tserp.model.PlacedStudent;
import com.ts.tserp.service.PlacedStudentService;

@RestController
public class PlacedStudentsController {

	@Autowired
	PlacedStudentService placedStudentService;
	
	@PostMapping("/add_placed_student")
	public PlacedStudent addPlacedStudent(@RequestBody PlacedStudent stud) {
		return placedStudentService.addPlacedStudent(stud);
	}

	@GetMapping("/get_placed_student/{id}")
	public PlacedStudent getPlacedStudent(@PathVariable long id) {
		return placedStudentService.getPlacedStudent(id);
	}
	
	@GetMapping("/get_placed_students")
	public List<PlacedStudent> getAllPlacedStudents() {
		return placedStudentService.getAllPlacedStudents();
	}
}

