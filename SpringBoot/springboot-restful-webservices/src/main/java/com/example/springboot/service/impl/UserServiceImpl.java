package com.example.springboot.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.springboot.dto.UserDto;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		//converting UserDto to User Jpa Entity
		User user= UserMapper.mapToUser(userDto);
		User savedUser = userRepo.save(user);
		
		//convert User Jpa Entity into User Dto	
		
		UserDto savedUserDto= UserMapper.mapToUserDto(savedUser);
		return savedUserDto;
		}
	

	@Override
	public UserDto getUserById(Long userId) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepo.findById(userId);
		User user = optionalUser.get();
		return UserMapper.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		 List<User> users = userRepo.findAll();
		 return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());

	}

	@Override
	public UserDto updateUser(UserDto user) {
		// TODO Auto-generated method stub
		User existingUser = userRepo.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepo.save(existingUser);
		return UserMapper.mapToUserDto(updatedUser);	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		userRepo.deleteById(userId);
		
	}

}
