package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/auth")
	public ResponseEntity login(@RequestBody Users users) {

		try {

			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(users.getUserName(), users.getPassword()));

			return new ResponseEntity("You login Successfully !!", HttpStatus.OK);

		} catch (BadCredentialsException badCredentialsException) {

			return new ResponseEntity("Username or password is Incorrect", HttpStatus.NOT_FOUND);
		}

	}

}
