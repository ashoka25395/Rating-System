package com.rating.rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rating.rating.pojo.UserRating;
import com.rating.rating.service.RatingService;


@RestController
@RequestMapping("/api")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@GetMapping("/aggregatedRating")
	public float getAggregatedRatingUserByUserId(@RequestParam int userId) {
		return ratingService.getAggregatedRatingUserByUserId(userId);
	}

	
	@PostMapping("/createUserRatingRecord")
	public UserRating createUserRatingRecord(@RequestParam int rating,@RequestParam int userId) {
		return ratingService.createUserRatingRecord(rating,userId);
	}

}
