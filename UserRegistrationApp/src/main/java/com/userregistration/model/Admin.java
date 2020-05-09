package com.userregistration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Admin")
public class Admin {
	@Id
	@Column(name = "adminId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;

	@Column(name = "adminName")
	private String adminName;

	@Column(name = "adminPassword")
	private String adminPassword;
}
