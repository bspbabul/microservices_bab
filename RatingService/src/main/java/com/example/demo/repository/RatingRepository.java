package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{

	List<Rating> findByUserId(String userid);
	List<Rating> findByHotelId(String hotelid);
}
