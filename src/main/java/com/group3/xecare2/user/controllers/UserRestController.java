package com.group3.xecare2.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group3.xecare2.user.dtos.UserCreateDto;
import com.group3.xecare2.user.entities.User;
import com.group3.xecare2.user.mappers.UserMapper;
import com.group3.xecare2.user.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping({ "/apis/v1/users" })
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping
	public List<User> getAllCustomers() {
		return userService.listAll();
	}
	
	@PostMapping
	public ResponseEntity<User> createCustomer(@RequestBody UserCreateDto userCreateDto) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(userCreateDto.getPassword());
		userCreateDto.setPassword(encodedPassword);
		
		// Map tự động bằng MapStruct
		//User user = userMapper.toEntity(userCreateDto);
		User user = new User();
		user.setName(userCreateDto.getName());
		user.setEmail(userCreateDto.getEmail());
		user.setPassword(userCreateDto.getPassword());
		user.setCreatedAt(userCreateDto.getCreatedAt());
		
		
		User savedUser = userService.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
}
