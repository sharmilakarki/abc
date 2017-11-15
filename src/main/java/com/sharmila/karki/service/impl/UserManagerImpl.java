package com.sharmila.karki.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharmila.karki.domain.User;
import com.sharmila.karki.repository.UserRepo;
import com.sharmila.karki.service.UserManager;

/**
 * @author Sharmila Karki
 *
 */
@Service
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User getById(String id) {

		return this.userRepo.findById(id);
	}

	@Override
	public User addNew(User user) {
		user.setCreatedDate(new Date());
		return this.userRepo.save(user);

	}

	@Override
	public User update(User u) {
		User user = this.userRepo.findById(u.getId());
		if (user != null) {
			user.setModifiedDate(new Date());
			this.userRepo.save(user);
		}
		return null;
	}

	@Override
	public List<User> getAll() {

		return this.userRepo.findAll();
	}

	@Override
	public void remove(String id) {
		User user = this.userRepo.findById(id);
		if (user != null) {
			this.userRepo.delete(user.getId());
		}

	}

	@Override
	public User findByEmail(String email) {

		return this.userRepo.findByEmail(email);
	}

}
