package com.studentapp.cucumber.serenity;

import java.util.HashMap;
import java.util.List;

import com.studentapp.model.StudentClass;
import com.studentapp.utils.ReusableSpecification;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StudentSerenityStep
{
	@Step("Creating a student with firstname : {0}, lastname : {1}, email : {2}, programme : {3}, courses : {4}")
	public ValidatableResponse createStudent(String firstname, String lastname, String email, String programme, List<String> courses)
	{
		StudentClass student = new StudentClass();
//		courses = new ArrayList<String>();		
//		courses.add("CS");
//		courses.add("ELE");
		
		student.setFirstName(firstname);
		student.setLastName(lastname);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);
		
		return SerenityRest.rest().given().
//		contentType(ContentType.JSON).
		spec(ReusableSpecification.getGenericRequestSpec()).
		when().
		body(student).log().all().
		post().
		then();
	}
	
	
	@Step("Getting the student with firstname : {0}")
	public HashMap<String,String> getStudentInfoByFirstname(String firstname)
	{
		
		HashMap<String,String> value = SerenityRest.rest().given().
		when().
		get("/list").
		then().
		extract().
		//path("findAll{it.firstName == ''}.firstName.get(0)");	//getting the 1st value from the ArrayList of all firstnames
		path("findAll{it.firstName == '"+firstname+"'}.get(0)");	//getting the 1st value from the HashMaps of specified firstname

		
		return value;
	}
	
	@Step("Updating a student with studentId : {0}, firstname : {1} lastname : {2}, email : {3}, programme : {4}, courses : {5}")
	public ValidatableResponse updateStudent(int studentId, String firstname, String lastname, String email, String programme, List<String> courses)
	{
		StudentClass student = new StudentClass();
//		courses = new ArrayList<String>();		
//		courses.add("CS");
//		courses.add("ELE");
		
		student.setFirstName(firstname);
		student.setLastName(lastname);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);
		
		return SerenityRest.rest().given().
//				contentType(ContentType.JSON).
				spec(ReusableSpecification.getGenericRequestSpec()).
		when().
		body(student).
		put("/"+studentId).
		then();
	}
	
	
	@Step("This step will delete the student with ID : {0}")
	public ValidatableResponse deleteStudentById(int id)
	{
		return SerenityRest.rest().given().
		when().
		delete("/"+id).
		then();
	}
}
