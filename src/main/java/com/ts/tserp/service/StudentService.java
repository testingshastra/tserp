package com.ts.tserp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.tserp.model.Student;
import com.ts.tserp.repo.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
		public String addStudent(Student student) {
			
			Student	 std = studentRepository.save(student);
			return "Student" +  std.getStudent_name()+ "has been added....!! ";
			
		}

		public List<Student> getAllStudents() {
		List<Student> stds =	(List<Student>) studentRepository.findAll();
			return stds;
		}

		public Student getStudent(Long id) {
		Optional<Student> std = studentRepository.findById(id);
			return std.isPresent()? std.get():new Student();
		}

		
				
		}

