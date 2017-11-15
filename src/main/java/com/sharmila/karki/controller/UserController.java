package com.sharmila.karki.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharmila.karki.domain.User;
import com.sharmila.karki.service.UserManager;

/**
 * @author Sharmila Karki
 *
 */
@RequestMapping(value = "/")
@RestController
public class UserController {

	@Autowired
	private UserManager userManager;

	@GetMapping()
	public List<User> findAll(User user) {
		return userManager.getAll();
	}

	@GetMapping(value = "/{id}")
	public User getUserById(@PathVariable("id") String id) {
		return this.userManager.getById(id);
	}

	@PostMapping
	public User addNewUser(@RequestBody @Valid User user) {
		User u = this.userManager.findByEmail(user.getEmail());
		if (u != null) {
			this.userManager.addNew(user);
		} else {
			throw new IllegalArgumentException("User already registered.");
		}
		return u;
	}

	@PutMapping(value = "/{id}")
	public User updateUser(@RequestBody @Valid User user, @PathVariable("id") String id) {
		User u = this.userManager.getById(id);
		if (u != null) {
			this.userManager.update(user);
		} else {
			throw new IllegalArgumentException("User not registered.");
		}
		return u;

	}

	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		User u = this.userManager.getById(id);
		if (u != null) {
			this.userManager.remove(id);
		} else {
			throw new IllegalArgumentException("Not a valid user to delete");
		}

	}
}
