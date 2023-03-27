package com.example.demo.externalservices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.Rating;

@FeignClient(name = "RATING-SERVICE/ratings")
public interface RatingService {

	@GetMapping
	public List<Rating> getRating();
	
	@GetMapping("/users/{userid}")
	public List<Rating> getRatingbyid(@PathVariable String userid);
	
	
}
