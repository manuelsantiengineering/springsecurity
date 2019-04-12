package com.spring.security.student.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.student.services.UserService;

import reactor.core.publisher.Mono;

@RestController
//@RequestMapping("/api/v1")
@CrossOrigin
public class UserController {

	@Autowired UserService userService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value="/all-users",produces="application/json")
	public Mono<Collection<String>> getAllUsers() {
		return Mono.just(userService.getAllUsers());
	}
}
