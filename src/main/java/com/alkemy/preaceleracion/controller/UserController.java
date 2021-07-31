package com.alkemy.preaceleracion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.preaceleracion.dto.Credential;
import com.alkemy.preaceleracion.dto.UserDTO;
import com.alkemy.preaceleracion.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public String logIn(@RequestBody Credential credential) {
		return userService.logIn(credential);
	}

	@PostMapping("/signIn")
	public ResponseEntity<UserDTO> signIn(@RequestBody UserDTO user) {
		if (userService.createUser(user)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}
		return ResponseEntity.status(400).body(user);
	}

}
