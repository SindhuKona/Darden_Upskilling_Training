package com.example.springboot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.springboot.dto.UserDto;
import com.example.springboot.exception.ErrorDetails;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

	private UserService userService;

	@PostMapping()
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto user) {
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);

	}

	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") long userId) {
		UserDto user = userService.getUserById(userId);
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);

	}

	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto user) {
		user.setId(userId);
		UserDto updateUser = userService.updateUser(user);
		return new ResponseEntity<UserDto>(updateUser, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("user Deleted Successfully", HttpStatus.OK);
	}

//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//			WebRequest webRequest) {
//
//		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
//				webRequest.getDescription(false), "USER_NOT_FOUND");
//
//		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//	}
}