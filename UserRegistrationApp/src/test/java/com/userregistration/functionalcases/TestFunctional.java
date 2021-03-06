package com.userregistration.functionalcases;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.userregistration.dao.UserDao;
import com.userregistration.model.User;
import com.userregistration.service.UserServiceImp;
import com.userregistration.utiltestclass.MasterData;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class TestFunctional {

	@Mock
	private UserDao userDao;

	@Mock
	private User user;

	@InjectMocks
	private UserServiceImp userServiceImp;

	@Test
	public void testSaveUsersImplTest() throws Exception {
		boolean value = userServiceImp.saveUser(MasterData.getDetails());
		assertEquals(Boolean.TRUE, value);
	}

	@Test
	public void testGetUsersImplTest() throws Exception {
		user = userServiceImp.getUser(MasterData.getDetails().getUserId());
		when(userDao.getUser(1)).thenReturn(null);
		User res = userServiceImp.getUser(1);
		assertEquals(null, res);
	}

	@Test
	public void testViewAllUsersImplTest() throws Exception {
		List<User> userList = new ArrayList<>();
		userList.add(new User());
		userList.add(new User());
		when(userDao.listUser()).thenReturn((List<User>) userList);
		List<User> list = userServiceImp.listUser();
		assertEquals(2, list.size());
	}

	@Test
	public void testViewAllUsersImplTest1() throws Exception {
		List<User> userList = new ArrayList<>();
		when(userDao.listUser()).thenReturn((List<User>) userList);
		List<User> list = userServiceImp.listUser();
		assertEquals(Collections.EMPTY_LIST, list);
	}

	@Test
	public void testViewAllUsersImplTest2() throws Exception {
		when(userDao.listUser()).thenReturn(null);
		List<User> list = userServiceImp.listUser();
		assertEquals(null, list);
	}
	
	@Test
	public void testDeleteUsersImplTest() throws Exception {
		User user = userServiceImp.getUser(MasterData.getDetails().getUserId());
		when(userDao.getUser(1)).thenReturn(user).thenReturn(null);
		User res = userServiceImp.getUser(1);
		assertEquals(null, res);
	}
}
