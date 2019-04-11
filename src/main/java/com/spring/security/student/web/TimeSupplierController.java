package com.spring.security.student.web;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1")
@CrossOrigin
public class TimeSupplierController {
	
	@GetMapping(value="/time",produces="application/json")
	private ZonedDateTime currentTime() {
		return ZonedDateTime.now();
	}
	
	@GetMapping(value="/secret-time",produces="application/json")
	private ZonedDateTime currentSecretTime() {
		return ZonedDateTime.now(ZoneId.of("UTC"));
	}

}
