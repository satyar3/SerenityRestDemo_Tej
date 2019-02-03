package com.studentapp.testbase;



import cucumber.api.java.Before;
import io.restassured.RestAssured;

public class TestBase
{
	@Before
	public void initialization()
	{
		RestAssured.baseURI = "http://localhost:8080";
		RestAssured.basePath = "/student";
		System.out.println("<---------------Base Extended---------->");
	}
}
