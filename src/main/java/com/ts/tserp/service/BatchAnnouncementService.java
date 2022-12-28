package com.ts.tserp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.tserp.model.BatchAnnouncement;
import com.ts.tserp.repo.BatchAnnouncementRepo;

@Service
public class BatchAnnouncementService {
	
	@Autowired
	private BatchAnnouncementRepo batchAnnouncementRepo;
	
	public BatchAnnouncement save(BatchAnnouncement batch) {
		return batchAnnouncementRepo.save(batch);
	}

	public BatchAnnouncement getBatchById(Long id) {
		return batchAnnouncementRepo.findById(id).orElse(null);
		
	}

	public List<BatchAnnouncement> getAllBatches() {
		return (List<BatchAnnouncement>) batchAnnouncementRepo.findAll();
	}

	public String deleteBatch(Long id) {
		batchAnnouncementRepo.deleteById(id);
		return "Batch "+id+" has been deleted";
	}
	
}
