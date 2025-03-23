package com.api.tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.modelRequest.LoginRequest;
import com.api.modelResponse.LoginResponse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {
	
	@Test(description = "verify if login API is working properly")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("uday1234", "uday12345");
		AuthService authService = new AuthService();
		
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);	
		
		//verify login response
		System.out.println(loginResponse.getId());
		System.out.println(response.prettyPrint());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
