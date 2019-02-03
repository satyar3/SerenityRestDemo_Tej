package com.studentapp.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class StudentSteps 
{
	@Given("^User sets up the env$")
	public void setUp()
	{		
		//initialization();
	}
	
	@When("^User sends a GET request to the endpoint, user gets back response code as 200$")
	public void getReq()
	{
		SerenityRest.rest().
		given().
		when().log().all().
		get("/list").
		then().log().all().
		statusCode(200);
	}

}
