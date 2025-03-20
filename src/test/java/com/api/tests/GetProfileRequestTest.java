package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.modelRequest.LoginRequest;
import com.api.modelResponse.LoginResponse;
import com.api.modelResponse.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	
	@Test
	public void getProfileRequestTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday1234","uday12345"));
		
		
		System.out.println(response.asPrettyString());
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
		UserProfileManagementService userProfileManagement = new UserProfileManagementService();
		response =userProfileManagement.getProfile(loginResponse.getToken());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
		
		
		
	}
       }

