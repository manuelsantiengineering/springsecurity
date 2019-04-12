package com.spring.security.student.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value="/user/{userId}",produces="application/json")
	public Mono<String> getSpecificUser(@PathVariable("userId") Integer userId, HttpServletRequest httpServletRequest) {
		if(httpServletRequest.isUserInRole("ROLE_USER")) {
			return Mono.justOrEmpty(userService.getById(userId));
		}else {
			return Mono.error(new Exception("Unauthorized user."));
		}
	}
}
