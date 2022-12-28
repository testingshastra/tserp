package com.ts.tserp.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ts.tserp.model.Student;
import com.ts.tserp.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/student")
	public String addStudent(@RequestBody Student student) {
		
		String result = studentService.addStudent(student);
		return result;
	}
	
	@GetMapping("/students")
	public List<Student>getAllStudents(){
	return 	studentService.getAllStudents();
	}
	
	
	@GetMapping("/student/{roll_no}")
	public Student getStudent(@PathVariable("roll_no") Long rollNo) {
		return studentService.getStudent(rollNo);
		}
}