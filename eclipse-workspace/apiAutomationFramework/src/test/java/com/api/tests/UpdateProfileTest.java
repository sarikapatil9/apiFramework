package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.modelRequest.LoginRequest;
import com.api.modelRequest.ProfileRequest;
import com.api.modelResponse.LoginResponse;
import com.api.modelResponse.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test
	public void updateProfileTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday1234","uday12345"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();		
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		
		
		UserProfileResponse userProfileResponse =  response.as(UserProfileResponse.class);
		
		ProfileRequest req = new ProfileRequest.Builder().setEmail("sarika.eng@gmail.com")
									.setFirstname("sarika")
									.setLastname("patilllllll")
									.setmobileNumber("8971231223").build();
		response = userProfileManagementService.updateProfile(req,loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		
	}

}
