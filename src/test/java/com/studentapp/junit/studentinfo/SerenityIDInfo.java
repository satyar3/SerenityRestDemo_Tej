package com.studentapp.junit.studentinfo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class SerenityIDInfo extends TestBase
{
	
	@Test
	public void getAllStudents()
	{
		//RestAssured.given().
		SerenityRest.given().
		when().
		get("/list").
		then().log().body().
		statusCode(200);
	}
	
	@Test //Failed Test
	public void thisIsAFailingTest()
	{
		SerenityRest.given().
		when().
		get("/list").
		then().
		statusCode(500);
	}
	
	@Pending
	@Test //Pending Test
	public void thisIsAPendingTest()
	{
		
	}
	
	@Ignore
	@Test //Ignored Test
	public void thisIsIgnoredTest()
	{
		
	}
	
	@Test //Error Test
	public void thisIsErrorTest()
	{
		System.out.println(1/0);
	}
	
	@Test //Compromised Test.....Set the property in property file
	public void thisIsCompromisedTest() throws IOException
	{
		File file = new File("C:\\text.txt");
		FileReader fr = new FileReader(file);
	}
	
	@Manual
	@Test //Compromised Test.....Set the property in property file
	public void thisIsManualTest() throws IOException
	{
		System.out.println("10");
	}
	
	@Title("This test will fetch all student details")
	@Test
	public void test01()
	{
		//RestAssured.given().
		SerenityRest.given().
		when().
		get("/list").
		then().log().body().
		statusCode(200);
	}
	
}
