package com.example.springboot.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.UserDto;
import com.example.springboot.entity.User;
import com.example.springboot.exception.EmailAlreadyExistsException;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		// converting UserDto to User Jpa Entity
//		User user= UserMapper.mapToUser(userDto);

		Optional<User> optionalUser = userRepo.findByEmail(userDto.getEmail());

		if (optionalUser.isPresent()) {
			throw new EmailAlreadyExistsException("Email Already Exists for User");
		}
		User user = modelMapper.map(userDto, User.class);

		User savedUser = userRepo.save(user);

		// convert User Jpa Entity into User Dto

//		UserDto savedUserDto= UserMapper.mapToUserDto(savedUser);
		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		return savedUserDto;
	}

	@Override
	public UserDto getUserById(Long userId) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

//		return UserMapper.mapToUserDto(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepo.findAll();
//		 return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());	

		return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

	}

	@Override
	public UserDto updateUser(UserDto user) {
		// TODO Auto-generated method stub
		User existingUser = userRepo.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", user.getId()));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepo.save(existingUser);
//		return UserMapper.mapToUserDto(updatedUser);
		return modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public void deleteUser(Long userId) {
		User existingUser = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

		// TODO Auto-generated method stub
		userRepo.deleteById(userId);

	}

}
