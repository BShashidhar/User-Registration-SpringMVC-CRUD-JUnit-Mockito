package com.social.imageApp.account.UtilTestClass;

import com.social.imageApp.account.model.User;

public class MasterData {
	public static User getDetails() {
		User user = new User();
		user.setUserId(1);
		user.setUserFirstName("Besta");
		user.setUserLastName("Shashidhar");
		user.setUserName("B Shashidhar");
		user.setUserEmail("shashi.2346@gmail.com");
		user.setUserPassword("1234567890");
		user.setProfilePicture("www.google.com");
		user.setActive(true);
		return user;
	}
//	public static User editDetails() {
//		User user = new User();
//		user.setUserFirstName("B");
//		user.setUserLastName("Shashidhar");
//		user.setUserName("B Shashidhar");
//		user.setUserEmail("shashi@gmail.com");
//		user.setUserPassword("1234567890");
//		user.setProfilePicture("noprofile");
//		user.setActive(true);
//		return user;
//	}
}