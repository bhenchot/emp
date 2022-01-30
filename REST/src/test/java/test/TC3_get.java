package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC3_get {
	
	@Test
	public void getweatherDetails() {
		
		//base uri
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response httpsResponse = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//Print response and body
		String responseBody = httpsResponse.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		
		String contentType = httpsResponse.header("Content-Type");
		System.out.println("Content Tupe is: "+contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		
		String contentEnco= httpsResponse.header("Content-Encoding");
		System.out.println("Content encodin is: "+contentEnco);
		Assert.assertEquals(contentEnco, "gzip");
	
		
		
	}

}
