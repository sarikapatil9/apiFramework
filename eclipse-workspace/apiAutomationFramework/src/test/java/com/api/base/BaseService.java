package com.api.base;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.api.filters.*;

public class BaseService {

	private static final String baseURL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}
	public BaseService() {
		requestSpecification = given().log().all().baseUri(baseURL);
	}
	
	protected void setAuthToken(String token) {
		 requestSpecification.header("Authorization","Bearer " + token);
	}
	protected Response postRequest(Object payLoad, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payLoad).post(endpoint);
	}
	
	protected Response putRequest(Object payLoad, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payLoad).put(endpoint);
	}
	
	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}
}
