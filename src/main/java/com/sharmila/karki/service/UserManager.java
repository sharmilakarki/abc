package com.sharmila.karki.service;

import com.sharmila.karki.domain.User;
import com.sharmila.karki.repository.CRUDManager;

/**
 * @author Sharmila Karki
 *
 */
public interface UserManager extends CRUDManager<User, String> {
	public User findByEmail(String email);

}
