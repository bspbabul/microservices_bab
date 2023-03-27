package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Rating;



public interface RatingService {
	Rating saveRating(Rating user);
	List<Rating> getAllRating();
	Optional<List<Rating>> getRatingbyUserid(String userId);
	Optional<List<Rating>> getRatingbyHotelid(String Hotel_id);

}
