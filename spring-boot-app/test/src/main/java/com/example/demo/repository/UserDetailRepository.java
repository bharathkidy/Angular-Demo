package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.UserEntity;

public interface UserDetailRepository extends JpaRepository<UserEntity,Integer> {
	@Query(nativeQuery=true,
				value="select * from user_details where email=?1 and password=?2")
	Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
