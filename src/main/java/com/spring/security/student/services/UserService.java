package com.spring.security.student.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	private static final Map<Integer, String> allUsers = new HashMap<>();
	static {
		allUsers.put(1, "Tomatito");
		allUsers.put(2, "Cebollin");
		allUsers.put(3, "Pimientin");
		allUsers.put(4, "Rabanin");
		allUsers.put(5, "Brocolin");
	}
	
	public Collection<String> getAllUsers(){
		return allUsers.values();
	}
	
	public String getById(Integer userId) {	return allUsers.get(userId);	}
}
