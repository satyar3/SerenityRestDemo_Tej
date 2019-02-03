package com.studentapp.junit.studentinfo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.cucumber.serenity.StudentSerenityStep;
import com.studentapp.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;


@Concurrent(threads="4x") //By default 2 threads per core, 4x means 4 threads per core.....it'll work only in parameterized test....use maven fail safe forkcount if want to execute normal tests in parallel
@UseTestDataFrom(value = "src\\test\\resources\\testdata\\TestData.csv", separator = ';')
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentDataDriven extends TestBase
{
	
	public String FIRSTNAME;
	public String LASTNAME;
	public String EMAIL;
	public String PROGRAMME;
	public String COURSES;
	
	public String getFIRSTNAME()
	{
		return FIRSTNAME;
	}

	public void setFIRSTNAME(String fIRSTNAME)
	{
		FIRSTNAME = fIRSTNAME;
	}

	public String getLASTNAME()
	{
		return LASTNAME;
	}

	public void setLASTNAME(String lASTNAME)
	{
		LASTNAME = lASTNAME;
	}

	public String getEMAIL()
	{
		return EMAIL;
	}

	public void setEMAIL(String eMAIL)
	{
		EMAIL = eMAIL;
	}

	public String getPROGRAMME()
	{
		return PROGRAMME;
	}

	public void setPROGRAMME(String pROGRAMME)
	{
		PROGRAMME = pROGRAMME;
	}

	public String getCOURSES()
	{
		return COURSES;
	}

	public void setCOURSES(String cOURSES)
	{
		COURSES = cOURSES;
	}


	@Steps
	StudentSerenityStep steps;
	
	@Title("Data driven test for adding multiple students to the student app")
	@Test
	public void createMultipleStudent()
	{
		
		String[] arr = COURSES.split(",");
		ArrayList<String> courses = new ArrayList<String>();
		
		for(int i = 0; i<arr.length; i++)
		{
			courses.add(arr[i]);
		}
		
		steps.createStudent(FIRSTNAME, LASTNAME, EMAIL, PROGRAMME, courses).log().all().
		statusCode(201);
	}
}
