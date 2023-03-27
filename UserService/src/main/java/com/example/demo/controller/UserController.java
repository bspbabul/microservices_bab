package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.serviceImpl.ServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private ServiceImpl serviceImpl;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1=serviceImpl.saveUser(user);
		return new ResponseEntity<User>(user1,HttpStatus.CREATED);
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userid){
		User user=serviceImpl.getUserById(userid);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> alluser=serviceImpl.getAllUser();
		return ResponseEntity.ok(alluser);
	}
	
	

}
