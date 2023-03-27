package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Rating;
import com.example.demo.feing.hotelsfeing;
import com.example.demo.repository.RatingRepository;
import com.example.demo.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private hotelsfeing hotelsfeing;

	@Override
	public Rating saveRating(Rating rating) {

		  String randomuuid=UUID.randomUUID().toString().replace("-","").substring(0,8);
		  rating.setRatingId(randomuuid);
		 
		
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() 
	{
		
		List<Rating> ratings=ratingRepository.findAll();
		for (Rating rating :ratings ) {
			List<Hotel> hotel=hotelsfeing.getAllHotel();
			rating.setHotel(hotel);
		}
		return ratings;
		
		
		
	}

	@Override
	public Optional<List<Rating>> getRatingbyUserid(String userId) {
		
		return Optional.ofNullable(ratingRepository.findByUserId(userId));
	}

	@Override
	public Optional<List<Rating>> getRatingbyHotelid(String Hotel_id) {
		
		return Optional.ofNullable(ratingRepository.findByHotelId(Hotel_id));
	}

	

}
