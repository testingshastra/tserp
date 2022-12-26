package com.ts.tserp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping("/add_batch")
	private BatchAnnouncement addBatch(@RequestBody BatchAnnouncement batch) {
		return batchAnnouncementService.save(batch);
	}
	
	@GetMapping("/get_Batch/{Id}")
	private BatchAnnouncement getBatchById(@PathVariable long id) {
		return batchAnnouncementService.getBatchById(id);
	}
}
