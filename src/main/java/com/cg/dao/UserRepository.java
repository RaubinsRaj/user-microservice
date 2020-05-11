package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entity.User;

public interface UserRepository extends JpaRepository<User,String> {

	@Query("from User where userId=?1")
	User findByUserId(String UserId);
    

}