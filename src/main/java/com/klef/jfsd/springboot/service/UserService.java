package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.repository.UserRepository;

@Component
public class UserService {
	@Autowired
	private UserRepository repo;
	public User insertUser(User user) {
        return repo.save(user);
    }
	public List<User> getAllUsers() {
	    return repo.findAll();
	}


    // Method to authenticate user credentials
 // Method to authenticate user credentials
    public User authenticateUser(String email, String password) {
        User user = repo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user; // return the user object if authenticated
        }
        return null; // return null if authentication fails
    }
	
}
