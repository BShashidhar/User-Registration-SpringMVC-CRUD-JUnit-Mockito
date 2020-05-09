package com.userregistration.functionalcases;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.userregistration.controller.UserController;
import com.userregistration.model.User;
import com.userregistration.service.UserService;
import com.userregistration.utiltestclass.MasterData;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class TestController {

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testLoadingPageUrl() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void testViewAllUsersApi() throws Exception {
		List<User> userList = new ArrayList<>();
		userList.add(new User());
		userList.add(new User());
		when(userService.listUser()).thenReturn((List<User>) userList);
		this.mockMvc.perform(get("/listAllUsers")).andExpect(status().isOk()).andExpect(view().name("ok"));
	}

	@Test
	public void testViewAllUsersApiCase1() throws Exception {
		when(userService.listUser()).thenReturn(null);
		this.mockMvc.perform(get("/listAllUsers")).andExpect(status().isOk())
				.andExpect(view().name("No Records Found"));
	}

	@Test
	public void testSaveUsersApiTestCase1() throws Exception {
		Gson gson = new Gson();
		when(userService.saveUser(MasterData.getDetails())).thenReturn(false);
		this.mockMvc
				.perform(post("/addUser").content(gson.toJson(MasterData.getDetails()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(view().name("record not saved"));

	}
}
