package com.group3.xecare2.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group3.xecare2.user.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
