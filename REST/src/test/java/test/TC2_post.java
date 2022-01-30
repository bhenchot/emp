package test;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC2_post {

	@Test
	@SuppressWarnings("unchecked")
	public void registerUser() {

		// base uri
		RestAssured.baseURI = "https://reqres.in/api";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Print response and body
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Sanket");
		requestParams.put("LastName", "Khamkar");
		requestParams.put("UserName", "sankkham");
		requestParams.put("Password", "123asd");
		requestParams.put("Email", "sanke@mail.com");

		httpRequest.headers("Content-Type", "application/json");

		httpRequest.body(requestParams.toJSONString());

		Response httpResponse2 = httpRequest.request(Method.POST, "/users");

		// Status code validation
		int statusCode = httpResponse2.getStatusCode();
		System.out.println("Status code is: " + statusCode);
		Assert.assertEquals(statusCode, 201);

		// success code validation
		String SuccessCode = httpResponse2.jsonPath().get("SuccessCode");
		Assert.assertEquals(SuccessCode, null);

	}

}
