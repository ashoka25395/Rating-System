package com.rating.rating.service;

import org.springframework.stereotype.Service;

import com.rating.rating.pojo.UserRating;

@Service
public interface RatingService {

	float getAggregatedRatingUserByUserId(int userId);

	UserRating createUserRatingRecord(int rating, int userId);

}
