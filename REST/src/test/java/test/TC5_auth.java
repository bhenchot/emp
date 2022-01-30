package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC5_auth {
	
	@Test
	public void getweatherDetails() {
		
		//base uri
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		auth.setUserName("ToolsQA");
		auth.setPassword("TestPassword");
		
		RestAssured.authentication=auth;
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response httpsResponse = httpRequest.request(Method.GET, "/");
		
		//Print response and body
		String responseBody = httpsResponse.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		
		
		//Status code validation
		int statusCode = httpsResponse.getStatusCode();
		System.out.println("Status code is: " +statusCode);
		Assert.assertEquals(statusCode, 200);									
		
		//Status line validation
		String statusLine = httpsResponse.getStatusLine();
		System.out.println("Status Line is: "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
	}

}
