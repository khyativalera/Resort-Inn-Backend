package com.example.restInn.controller;

import com.example.restInn.entity.Users;
import com.example.restInn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
