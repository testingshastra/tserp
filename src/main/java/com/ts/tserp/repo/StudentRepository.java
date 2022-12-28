package com.ts.tserp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ts.tserp.model.Student;



@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	
}
 