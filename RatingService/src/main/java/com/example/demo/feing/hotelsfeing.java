package com.example.demo.feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Hotel;



@FeignClient(name = "HOTEL-SERVICE")
public interface hotelsfeing {

	@GetMapping("/hotels")
	public List<Hotel> getAllHotel();
	
}
