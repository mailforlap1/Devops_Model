package com.example.crud_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.crud_app.model.User;
import com.example.crud_app.repository.UserRepository;


@Component
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
	}
	
	public User createUser(User user) {
		
		return userRepository.save(user);
		
	}
	
	public Optional<User> getsingleUser(Long id) {
		
		return userRepository.findById(id);
	}
	
	public void deleteuser(Long id) {
		
		userRepository.deleteById(id);
		
		
	}
	
	public User updateUser(Long id,User updateduser) {
		
		User user=userRepository.findById(id).orElse(null);
		
		if(user==null) return null;
		
		user.setName(updateduser.getName());
		user.setEmail(updateduser.getEmail());
		
		return userRepository.save(user);
	}

}
