package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/Users")
	public ResponseEntity<Users> getUsers() {

		List<Users> user = userService.getUsers();

		if (user != null) {
			return new ResponseEntity(user, HttpStatus.OK);
		} else {
			return new ResponseEntity(user, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/Users/{userId}")
	public ResponseEntity getUser(@PathVariable String userId) {

		Users user = userService.getUser(userId);

		if (user != null) {
			return new ResponseEntity(user, HttpStatus.OK);
		} else {
			return new ResponseEntity(new Users(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/Users")
	public ResponseEntity<Users> createUser(@RequestBody Users users) {

		Users user = userService.addUser(users);
		return new ResponseEntity(user, HttpStatus.OK);
	}

}
