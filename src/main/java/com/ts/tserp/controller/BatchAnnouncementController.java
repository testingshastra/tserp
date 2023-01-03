package com.ts.tserp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ts.tserp.model.BatchAnnouncement;
import com.ts.tserp.service.BatchAnnouncementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BatchAnnouncementController {

	@Autowired
	private BatchAnnouncementService batchAnnouncementService;
	
	@PostMapping("/add_batch_announcement")
	private BatchAnnouncement addBatch(@RequestBody BatchAnnouncement batch) {
		return batchAnnouncementService.save(batch);
	}
	
	@GetMapping("/get_batch_announcement/{id}")
	private BatchAnnouncement getBatchById(@PathVariable("id") Long id) {
		return batchAnnouncementService.getBatchById(id);
	}
	
	@GetMapping("/get_batch_announcements")
	private List<BatchAnnouncement> getBatches() {
		return batchAnnouncementService.getAllBatches();
	}
	
	@DeleteMapping("/delete_batch_announcement/{id}")
	private String deleteBatch(@PathVariable Long id) {
		return batchAnnouncementService.deleteBatch(id);
	}
}
