package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserDetailRepository;

class UserDetailServiceTest {
	
	@InjectMocks
	private UserDetailService userDetailsService;
	
	@Mock
	private UserDetailRepository userDetailRepository;

	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testGetUsers() {
		when(userDetailRepository.findAll())
			.thenReturn(Arrays.asList(new UserEntity(1,"James","James@123.com","EMPLOYEE"),
					new UserEntity(2,"Peter","Peter@123.com","EMPLOYEE"),
					new UserEntity(3,"John","John@123.com","ADMIN"),
					new UserEntity(4,"Fred","Fred@123.com","ADMIN")));
		
		List<UserEntity> loUserEntity = userDetailsService.getUsers().getBody();
		assertEquals("Fred",loUserEntity.get(0).getName());
		
	}

}
