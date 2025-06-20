package com.group3.xecare2.user.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group3.xecare2.user.entities.User;
import com.group3.xecare2.user.repositories.UserRepository;
import com.group3.xecare2.user.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByEmail(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}


}
