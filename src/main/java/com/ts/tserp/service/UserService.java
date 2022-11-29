package com.ts.tserp.service;

import java.util.List;

import com.ts.tserp.model.Role;
import com.ts.tserp.model.User;

public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUsers();
}
