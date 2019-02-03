package com.studentapp.utils;

import java.util.concurrent.TimeUnit;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class ReusableSpecification
{
	public static RequestSpecBuilder requestSpecBuilder;
	public static RequestSpecification requestSepc;
	
	public static ResponseSpecBuilder responseSpecBuilder;
	public static ResponseSpecification responseSepc;
	
	public static RequestSpecification getGenericRequestSpec()
	{
		requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setContentType(ContentType.JSON);
		
		requestSepc = requestSpecBuilder.build();
		
		return requestSepc;
		
	}
	
	
	public static ResponseSpecification getGenericResponseSpec()
	{
		responseSpecBuilder = new ResponseSpecBuilder();
		responseSpecBuilder.expectHeader("Content-Type", "application/json;charset=UTF-8");
		responseSpecBuilder.expectHeader("Transfer-Encoding", "chunked");
		responseSpecBuilder.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
		
		responseSepc = responseSpecBuilder.build();
		
		return responseSepc;
		
	}
}
