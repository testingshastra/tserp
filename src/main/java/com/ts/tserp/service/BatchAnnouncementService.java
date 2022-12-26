package com.ts.tserp.service;

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

	public BatchAnnouncement getBatchById(long id) {
		return batchAnnouncementRepo.findById(id).orElse(null);
	}
	
}
