package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class First {

	@Test

	public void test_1() {

		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());

		int statusCode =  response.getStatusCode();

		Assert.assertEquals(statusCode, 200);
	}


	@Test

	public void test_2() {

		baseURI="https://reqres.in/api/";
		given().get("/users/2").then().statusCode(200);


	}
}

