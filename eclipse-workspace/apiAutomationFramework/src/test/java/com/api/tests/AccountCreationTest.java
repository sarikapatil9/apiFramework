package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.modelRequest.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test
	public void createAccountTest() {
		SignUpRequest signUpRequest = new SignUpRequest.Builder().userName("sarika").password("sarika123")
				.firstName("sarika").lastName("patil").email("sarika.eng@gmail.com").mobileNumber("8971231223").build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUP(signUpRequest);
		
		System.out.println(response.prettyPrint());
		
	}

}
