package com.ts.tserp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ts.tserp.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{
	Role findByName(String name);
}
