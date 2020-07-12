package com.rating.rating.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rating.rating.pojo.UserRating;

@Repository
public interface UserRatingRepository extends PagingAndSortingRepository<UserRating, Integer>{

	@Query("SELECT AVG(ur.rating) FROM UserRating ur WHERE ur.user.id = ?1") 
	int findAverageRatingOfUser(int userId);

}
