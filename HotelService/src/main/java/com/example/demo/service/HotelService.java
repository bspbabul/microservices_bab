package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Hotels;



public interface HotelService {
	Hotels saveHotel(Hotels user);
	List<Hotels> getAllHotel();
	Optional<Hotels> getHotelById(String User_id);

}
