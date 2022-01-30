package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC4_get {
	
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
		
		Headers allHeaders = httpsResponse.headers();
		
		for (Header header:allHeaders) {
			
			System.out.println(header.getName()+ "   "+header.getValue());
		}
		
		
	}

}
