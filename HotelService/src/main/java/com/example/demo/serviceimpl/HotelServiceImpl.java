package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotels;
import com.example.demo.exception.HotelNotFoundException;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotels saveHotel(Hotels hotel) {

		  String randomuuid=UUID.randomUUID().toString().replace("-","").substring(0,8);
		  hotel.setId(randomuuid);
		 
		
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotels> getAllHotel() {
		
		return hotelRepository.findAll();
	}

	@Override
	public Optional<Hotels> getHotelById(String Hotel_id) {
		
		return Optional.ofNullable(hotelRepository.findById(Hotel_id).orElseThrow(()-> new HotelNotFoundException("hotel is not there in the database")));
	}

}
