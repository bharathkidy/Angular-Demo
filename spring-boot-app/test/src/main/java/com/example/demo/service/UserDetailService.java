package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserDetailRepository;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.InvalidCredentials;
import com.example.demo.model.LoginDetails;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserDetailService {
	private final UserDetailRepository userDetailRepository;
	
	public ResponseEntity<List<UserEntity>> getUsers() {
		List<UserEntity> loUsers = userDetailRepository.findAll();
		Collections.sort(loUsers,(user1,user2)->user1.getName().compareTo(user2.getName()));
		return new ResponseEntity<>(loUsers,HttpStatus.OK);
	}
	
	public ResponseEntity<UserEntity> getUser(String userId) {
		Optional<UserEntity> optionalUsr = userDetailRepository.findById(Integer.parseInt(userId));
		if(optionalUsr.isPresent() ) {
			return new ResponseEntity<UserEntity>(optionalUsr.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	public ResponseEntity<UserEntity> login(LoginDetails loginDetails) {
		Optional<UserEntity> optionalUsr = userDetailRepository.findByEmailAndPassword(loginDetails.getUserName(),
				loginDetails.getPassword());
		if(optionalUsr.isPresent() ) {
			return new ResponseEntity<UserEntity>(optionalUsr.get(),HttpStatus.OK);
		} else {
			throw new InvalidCredentials("Invalid Credentials");
		}
	}
}
