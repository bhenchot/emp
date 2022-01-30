package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Second {

//	@Test
//
//	public void Get() {
//
//		baseURI="https://reqres.in/api/";
//		given().
//		get("/users?page=2").
//		then().
//		statusCode(200).
//		body("data[1].first_name", equalTo("Lindsay")).
//		body("data.last_name",hasItems("Funke, Fields"));
//
//	}

	@SuppressWarnings("unchecked")
	@Test
	public void Post() {

		Map<String, Object>map = new HashMap<String, Object>();

		JSONObject request = new JSONObject();

		request.put("name","Raghav");
		request.put("job","Teacher");

		System.out.println(request.toJSONString());

		baseURI="https://reqres.in/api/";
		given().body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201);


	}
}



