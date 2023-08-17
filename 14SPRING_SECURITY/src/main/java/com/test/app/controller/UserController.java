package com.test.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.app.domain.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	
	@GetMapping("/join")
	public void join_get() {
		log.info("GET /join");
	}
	
	@PostMapping("/join")
	public void join_post(UserDto dto) {
		log.info("POST /join" + dto);
		
//		01
		
//		02
		
//		03
		dto.setRole("ROLE_USER");
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
//		04
		
		
		
		
		
		
		
	}
}
