package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Rating;
import com.example.demo.entities.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.externalservices.RatingService;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class ServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RatingService ratingService;

	@Override
	public User saveUser(User user) {
		
		
		
		  String randomuuid=UUID.randomUUID().toString().replace("-","").substring(0,8);
		  user.setUserid(randomuuid);
		 
		 
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		List<User> user = userRepository.findAll();
		for (User user2 : user) {
			List<Rating> rating=ratingService.getRating();
			user2.setRating(rating);
		}
		return user;
	}

	@Override
	public User getUserById(String userid) {
		
	User user=userRepository.findById(userid).orElseThrow(()-> new UserNotFoundException("user is not there by this id"));
		  
	List<Rating> re=ratingService.getRatingbyid(userid);
	user.setRating(re);
		 
		return user;
		
		
	}

}
