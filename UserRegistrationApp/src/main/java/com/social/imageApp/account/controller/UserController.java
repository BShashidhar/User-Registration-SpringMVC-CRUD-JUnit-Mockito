package com.social.imageApp.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.imageApp.account.model.User;
import com.social.imageApp.account.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	/* 
	 * add User
	 *  */
	@PostMapping("/addUser")
	public String save(@RequestBody User user) {
		Boolean value = userService.saveUser(user);
		if(value) {
			return "ok";
		}
		return "record not saved";
	}
	
	/* 
	 * Single select
	 *  */
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> get(@PathVariable("id") int userId) {
		User user = userService.getUser(userId);
		return ResponseEntity.ok().body(user);
	}
	
	/* 
	 * Multi select
	 *  */
	@RequestMapping(value = "/listAllUsers", method = RequestMethod.GET)
	public String listAllUsers() {
		try {
			List<User> user = userService.listUser();
			if(!CollectionUtils.isEmpty(user)) {
				return "ok";
			}
			throw new RuntimeException("No Records Found");
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	

	/* 
	 * Update User
	 *  */
	@PutMapping("/updUser/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int userId, @RequestBody User user) {
		userService.updateUser(userId, user);
		return ResponseEntity.ok().body("User has been updated successfully.");
	}

	/*
	 * Delete user by id
	 * */
	@DeleteMapping("/delUser/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int userId) {
		userService.deleteUser(userId);
		return ResponseEntity.ok().body("User has been deleted successfully.");
	}

	@GetMapping(value = "/")
	public String welcomePage() {
		return "ok";
	}	
}
