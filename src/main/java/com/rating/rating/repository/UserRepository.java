package com.rating.rating.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rating.rating.pojo.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer>{

}
