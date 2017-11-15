package com.sharmila.karki.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sharmila.karki.domain.User;


/**
 * @author Sharmila Karki
 *
 */
public interface UserRepo extends MongoRepository<User, Serializable>{
	public User findByEmail(String email);
	public User findById(String id);
	
}
