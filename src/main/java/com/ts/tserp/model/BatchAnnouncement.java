package com.ts.tserp.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "batch_announcement")
public class BatchAnnouncement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String course_title;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date start_date;
	private double start_time;
	private String mode;
	private String trainer_name;

}
