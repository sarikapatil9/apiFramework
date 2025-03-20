package com.api.base;

import com.api.modelRequest.ProfileRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService{
	
	private static final String BASE_PATH = "/api/users/";
	
	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"profile");
	}
	
	public Response updateProfile(ProfileRequest payLoad,String token) {
		setAuthToken(token);
		return putRequest(payLoad,BASE_PATH+"profile");
	}

}
