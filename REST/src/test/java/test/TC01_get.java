package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC01_get {
	
	@Test
	public void getweatherDetails() {
		
		//base uri
		RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response httpsResponse = httpRequest.request(Method.GET, "/Hyderabad");
		
		//Print response and body
		String responseBody = httpsResponse.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		Assert.assertEquals(responseBody.contains("Hyderabad"), true);			//check body available or not
		
		//Status code validation
		int statusCode = httpsResponse.getStatusCode();
		System.out.println("Status code is: " +statusCode);
		Assert.assertEquals(statusCode, 200);									
		
		//Status line validation
		String statusLine = httpsResponse.getStatusLine();
		System.out.println("Status Line is: "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		JsonPath jsonpath = httpsResponse.jsonPath();
		
		System.out.println(jsonpath.get("City"));
		System.out.println(jsonpath.get("Temperature"));
		System.out.println(jsonpath.get("Humidity"));
		System.out.println(jsonpath.get("WeatherDescription"));
		System.out.println(jsonpath.get("WindSpeed"));
		System.out.println(jsonpath.get("WindDirectionDegree"));
		
		//Assert.assertEquals(jsonpath.get("Temperature"), "91 Degree celsius");
		
		
		
	}

}
