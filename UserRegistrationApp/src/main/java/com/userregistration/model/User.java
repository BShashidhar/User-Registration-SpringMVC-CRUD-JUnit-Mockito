package com.userregistration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User {
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "userFirstName")
	private String userFirstName;

	@Column(name = "userLastName")
	private String userLastName;

	@NotNull
	@Column(name = "userName")
	private String userName;
	
	@NotNull
	@Column(name = "userEmail")
	private String userEmail;

	@Column(name = "userPassword")
	private String userPassword;

	@Column(name = "profilePicture")
	String profilePicture;

	@Column(name = "isActive")
	private boolean active = true;
}