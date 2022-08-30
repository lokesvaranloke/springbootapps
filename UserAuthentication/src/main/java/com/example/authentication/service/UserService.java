package com.example.authentication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.entity.User;
import com.example.authentication.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	public Iterable<User> GetAllUsers() {
		return repo.findAll();
	}

	public void saveUser(User user) {
		repo.save(user);
	}

	public User getUserByName(String name) {

		User user = repo.findByName(name);
		return user;

	}

	public User getUserById(int id) {
		Optional<User> optional = repo.findById(id);

		if (!optional.isPresent()) {
			System.out.println("Invalid User - User not present");
		}
		return optional.get();
	}
}
