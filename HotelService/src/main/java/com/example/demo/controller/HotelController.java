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

import com.example.demo.entity.Hotels;
import com.example.demo.serviceimpl.HotelServiceImpl;


@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelServiceImpl serviceImpl;
	
	@PostMapping
	public ResponseEntity<Hotels> createHotel(@RequestBody Hotels hotels){
		Hotels hotels1=serviceImpl.saveHotel(hotels);
		return new ResponseEntity<Hotels>(hotels1,HttpStatus.CREATED);
	}
	
	@GetMapping("/{hotelid}")
	public ResponseEntity<Optional<Hotels>> getSingleHotel(@PathVariable String hotelid){
		Optional<Hotels> hotel=serviceImpl.getHotelById(hotelid);
		return ResponseEntity.ok(hotel);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotels>> getAllHotel(){
		List<Hotels> allhotel=serviceImpl.getAllHotel();
		return ResponseEntity.ok(allhotel);
	}
	

}
