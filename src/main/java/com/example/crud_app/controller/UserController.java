package com.example.crud_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_app.model.User;
import com.example.crud_app.services.UserServices;

@RestController
@RequestMapping("/api/users")

public class UserController {
	
	
	@Autowired
	private UserServices userservices;
	
	
	
	@GetMapping
	public List<User> getusers(){
		return userservices.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public Optional<User> getuser(@PathVariable Long id) {
		
		return userservices.getsingleUser(id);
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		
		return userservices.createUser(user);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user,@PathVariable Long id) {
		
		return userservices.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		
		userservices.deleteuser(id);
	}
	
	
	
	
	

}
