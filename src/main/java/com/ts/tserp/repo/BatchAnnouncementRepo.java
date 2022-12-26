package com.ts.tserp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.tserp.model.BatchAnnouncement;

@Repository
public interface BatchAnnouncementRepo extends JpaRepository<BatchAnnouncement, Long>{
	
}
