package com.ts.tserp;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ts.tserp.model.Role;
import com.ts.tserp.model.User;
import com.ts.tserp.service.UserService;

@SpringBootApplication
public class TserpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TserpApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			
			userService.saveUser(new User(null, "Admin", "admin", "Test@123", new ArrayList<>()));
			userService.saveUser(new User(null, "User", "user", "Test@123", new ArrayList<>()));
			
			userService.addRoleToUser("admin",  "ROLE_ADMIN");
			userService.addRoleToUser("admin",  "ROLE_SUPER_ADMIN");
		};
	}

}
