package com.example.apiGarbageSimulation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiGarbageSimulation.entities.Usuario;
import com.example.apiGarbageSimulation.services.IAuthenticationService;

@RestController	
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	IAuthenticationService authentication;
	
	@PostMapping("")
	public ResponseEntity login(@RequestBody Usuario user) {
		
		Usuario userBD = authentication.searchUserBD(user.getUsername());
		
		if (userBD.getPassword().equals(user.getPassword())) {
			String token = authentication.getJWTToken(user.getUsername());
			user.setToken(token);		
			return ResponseEntity.ok(user);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		
	}
	
}
