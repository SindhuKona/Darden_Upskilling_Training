package com.example.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);

	}

	@Override
	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepo.findById(userId);
		return optionalUser.get();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();

	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User existingUser = userRepo.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepo.save(existingUser);
		return updatedUser;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		userRepo.deleteById(userId);
		
	}

}
