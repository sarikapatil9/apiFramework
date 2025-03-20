package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.modelRequest.SignUpRequest;

import io.restassured.response.Response;

public class ForgotPasswordTest {

	@Test
	public void forgotPasswordTest() {
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("testautomationacademy33@gmail.com");
		System.out.println(response.prettyPrint());
		
	}
}
