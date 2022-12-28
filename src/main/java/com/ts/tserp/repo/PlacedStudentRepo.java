package com.ts.tserp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.tserp.model.PlacedStudent;

@Repository
public interface PlacedStudentRepo extends JpaRepository<PlacedStudent, Long>{

}
