package com.ts.tserp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ts.tserp.model.User;

public interface UserRepo extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
