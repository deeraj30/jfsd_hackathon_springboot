package com.klef.jfsd.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	private UserService dao;
	@GetMapping("/")
    public String fun1() {
        return "Welcome";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String registerUser(@RequestBody User user) {
        dao.insertUser(user);
        return "User registered successfully with role: " + user.getRole();
    }

    // Sign-in endpoint
 // Sign-in endpoint
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody User user) {
        User authenticatedUser = dao.authenticateUser(user.getEmail(), user.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

	

}
