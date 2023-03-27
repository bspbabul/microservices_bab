package com.example.demo.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	private String RatingId;
	private String UserId;
	private String HotelId;
	private int rating;
	private String feedback;

	private List<Hotel> hotel;
}
