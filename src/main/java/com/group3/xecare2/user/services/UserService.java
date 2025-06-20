package com.group3.xecare2.user.services;

import java.util.List;

import com.group3.xecare2.user.entities.User;

public interface UserService {

	User findByEmail(String username);

	List<User> listAll();

	User save(User user);

}
