package com.ts.tserp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.tserp.model.PlacedStudent;
import com.ts.tserp.repo.PlacedStudentRepo;

@Service
public class PlacedStudentService {

	@Autowired
	PlacedStudentRepo placedStudentRepo;
	
	public PlacedStudent addPlacedStudent(PlacedStudent stud) {
		return placedStudentRepo.save(stud);
	}

	public PlacedStudent getPlacedStudent(long id) {
		return placedStudentRepo.findById(id).orElse(null);
	}

	public List<PlacedStudent> getAllPlacedStudents() {
		return (List<PlacedStudent>)placedStudentRepo.findAll();
	}

	
	
}
