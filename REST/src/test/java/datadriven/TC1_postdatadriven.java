package datadriven;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC1_postdatadriven {

	@Test(dataProvider = "empdataprovider")
	@SuppressWarnings("unchecked")
	public void registerUser(String eid, String ename, String ejob, String eemail) {

		// base uri
		RestAssured.baseURI = "https://reqres.in/api";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Print response and body
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", eid);
		requestParams.put("name", ename);
		requestParams.put("job", ejob);
		requestParams.put("email", eemail);

		httpRequest.headers("Content-Type", "application/json");

		httpRequest.body(requestParams.toJSONString());

		Response httpResponse2 = httpRequest.request(Method.POST, "/users");

		String responseBody = httpResponse2.getBody().asString();

		System.out.println("EResponse body is:" + responseBody);

		Assert.assertEquals(responseBody.contains(eid), true);
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(ejob), true);
		Assert.assertEquals(responseBody.contains(eemail), true);

		// Status code validation
		int statusCode = httpResponse2.getStatusCode();
		System.out.println("Status code is: " + statusCode);
		Assert.assertEquals(statusCode, 201);

	}

	@DataProvider(name = "empdataprovider")
	String[][] getEmpData() {
		String empData[][] = { { "8", "Sanket", "QA", "sanke@mail.com" }, { "9", "Swatee", "Analyst", "swat@mail.com" },
				{ "10", "Salonee", "Microbiologist", "salon@mail.com" } };
		return empData;

	}

}
