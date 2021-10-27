package com.example.demo.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.LoginDetails;
import com.example.demo.service.UserDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserDetailService userDetailService;
	
	@GetMapping(value="/users",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserEntity>> getUsers() {
		return userDetailService.getUsers();
	}
	
	@GetMapping(value="/user/{user-id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> getUser(
			@PathVariable(name="user-id") String userId) {
		return userDetailService.getUser(userId);
	}
	
	@PostMapping(value="/login",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> login(
			@RequestBody LoginDetails loginDetails) {
		return userDetailService.login(loginDetails);
	}
}
