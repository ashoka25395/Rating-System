package com.rating.rating.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.rating.exception.ResourceNotFoundException;
import com.rating.rating.pojo.User;
import com.rating.rating.pojo.UserRating;
import com.rating.rating.repository.UserRatingRepository;
import com.rating.rating.repository.UserRepository;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private UserRatingRepository userRatingRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public float getAggregatedRatingUserByUserId(int userId) {
		Optional<UserRating> optionalUserRating=userRatingRepository.findByUserId(userId);
		if(optionalUserRating.isPresent()) {
			DecimalFormat df = new DecimalFormat("#.00");  
			return  Float.valueOf(df.format(userRatingRepository.findAverageRatingOfUser(userId)));
		}
		else {
			//throw some exception
			throw new ResourceNotFoundException("user rating", "userId", userId);
		}
	}

	@Override
	public UserRating createUserRatingRecord(int rating, int userId) {
		Optional<User> optionalUser=userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			return userRatingRepository.save(new UserRating(optionalUser.get(), rating,new Date(),new Date()));
		}
		else {
			throw new ResourceNotFoundException("user", "id", userId);
		}
	}

}
