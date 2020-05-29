package com.wearperfect.datastoreapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wearperfect.datastoreapi.models.User;
import com.wearperfect.datastoreapi.repositories.UserRepository;
import com.wearperfect.datastoreapi.service.UserService;

@RestController
@RequestMapping(path="/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("")
	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();
	}
	
	@GetMapping("/id/{id}")
	public User getUserDetailsByUserId(Long userId) {
		return userService.getUserDetails(userId);
	}
	
	@GetMapping("/{username}")
	public User getUserDetailsByUserId(String username) {
		return userService.getUserDetails(username);
	}
}
