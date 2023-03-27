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

import com.example.demo.entity.Rating;
import com.example.demo.serviceimpl.RatingServiceImpl;


@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingServiceImpl serviceImpl;
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating rating1=serviceImpl.saveRating(rating);
		return new ResponseEntity<Rating>(rating1,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Rating>> getRating(){
		List<Rating> allhotel=serviceImpl.getAllRating();
		return ResponseEntity.ok(allhotel);
	}
	
	@GetMapping("/hotels/{hotelid}")
	public ResponseEntity<Optional<List<Rating>>> getRatingByHotelId(@PathVariable String hotelid){
		Optional<List<Rating>> rating=serviceImpl.getRatingbyHotelid(hotelid);
		return ResponseEntity.ok(rating);
	}
	

	@GetMapping("/users/{userid}")
	public ResponseEntity<Optional<List<Rating>>> getRatingByUserId(@PathVariable String userid){
		Optional<List<Rating>> rating=serviceImpl.getRatingbyUserid(userid);
		return ResponseEntity.ok(rating);
	}
	

}
