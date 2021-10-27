package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="user_details")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;
	
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	
	@Column(name="ROLE")
	private String role;
}
