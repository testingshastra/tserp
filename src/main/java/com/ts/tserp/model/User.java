package com.ts.tserp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String first_name;
	public String last_name;

	public String phone_no;
	String regex = "//d{10}";

	public String email;
	String regex1 = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

	public String role;
	public String password;
	String regex2 = "^[A-Za-z0-9])[#?!@$%^&*-])d{8}$";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String phone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {

		if (phone_no.matches(regex)) {
			this.phone_no = phone_no;
		}
	}

	public String email() {
		return phone_no;
	}

	public void setemail(String email) {

		if (email.matches(regex1)) {
			this.email = email;
		}

	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String password() {
		return password;
	}
	public void setpassword(String password) {

		if (password.matches(regex2)) {
			this.password = password;
		}

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", phone_no=" + phone_no
				+ ", email=" + email + ", role=" + role + ", password=" + password + "]";
	}
	
}
