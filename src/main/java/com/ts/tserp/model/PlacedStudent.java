package com.ts.tserp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Recent placement")
public class PlacedStudent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
	
	@Column(name = "Student name")
		private String student_name;
	
	@Column(name ="Company name")
		private String company_name;
	
		private String emailId;
		
		private int phone_no;
		
		private String position;
		
		private int salary;
		
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getStudent_name() {
			return student_name;
		}
		public void setStudent_name(String student_name) {
			this.student_name = student_name;
		}
		public String getCompany_name() {
			return company_name;
		}
		public void setCompany_name(String company_name) {
			this.company_name = company_name;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public int getPhone_no() {
			return phone_no;
		}
		public void setPhone_no(int phone_no) {
			this.phone_no = phone_no;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		
		
		
		
		
}
