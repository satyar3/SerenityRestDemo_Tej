package com.studentapp.junit.studentinfo;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.studentapp.cucumber.serenity.StudentSerenityStep;
import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReusableSpecification;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentsCrudTest extends TestBase
{	
	
	StudentClass student;
	List<String> courses;
	static int studentId;
	String firstname = "firstname1";
	String lastname = "lastname1";
	String email = "email1@email.com";
	String programme = "testprog1";	
	
	@Steps
	StudentSerenityStep steps;
	
	@Title("This test will create a new student")
	@Test
	public void test001()
	{
//		student = new StudentClass();
		courses = new ArrayList<String>();		
		courses.add("CS");
		courses.add("ELE");
		
//		student.setFirstName("firstname1");
//		student.setLastName("lastname1");
//		student.setEmail("email1@email.com");
//		student.setProgramme("testprog1");
//		student.setCourses(courses);
		
		
		firstname = "firstname1";
		lastname = "lastname1";
		email = "email1@email.com";
		programme = "testprog1";	
		
		
		steps.createStudent(firstname, lastname, email, programme, courses).
		statusCode(201).
		spec(ReusableSpecification.getGenericResponseSpec());
		
//		SerenityRest.rest().given().
//		contentType(ContentType.JSON).
//		log().all().
//		when().
//		body(student).
//		post().
//		then().log().all().
//		statusCode(201);
	}
	
	@Title("This test will verify the addition of new student")
	@Test
	public void test002()
	{
	
//		HashMap<String,String> value = SerenityRest.rest().given().
//		when().
//		get("/list").
//		then().log().all().
//		statusCode(200).
//		extract().
//		//path("findAll{it.firstName == ''}.firstName.get(0)");	//getting the 1st value from the ArrayList of all firstnames
//		path("findAll{it.firstName == 'firstname1'}.get(0)");	//getting the 1st value from the HashMaps of specified firstname
		
		HashMap<String,String> value = steps.getStudentInfoByFirstname(firstname);
		
		System.out.println("The value is : "+value);
			
		assertThat(value, hasValue("firstname1"));
		
		studentId = Integer.parseInt(String.valueOf(value.get("id")));
		System.out.println("Student Id is : "+studentId);
	}
	
	@Title("This test will update the newly added student")
	@Test
	public void test003()
	{
		student = new StudentClass();
		courses = new ArrayList<String>();
		
		courses.add("CS");
		courses.add("ELE");
	
//		student.setId(1);
//		student.setFirstName("firstname22");
//		student.setLastName("lastname1");
//		student.setEmail("email1@email.com");
//		student.setProgramme("testprog1");
//		student.setCourses(courses);
		
		steps.updateStudent(studentId, "firstname22", "lastname1", "email1@email.com", "testprog1", courses).
		statusCode(200).
		spec(ReusableSpecification.getGenericResponseSpec());;
		
		HashMap<String, String> studentDetails = steps.getStudentInfoByFirstname("firstname22");
		assertThat(studentDetails, hasValue("firstname22"));
		
//		SerenityRest.rest().given().
//		contentType(ContentType.JSON).
//		log().all().
//		when().
//		body(student).
//		put("/"+studentId).
//		then().log().all();
		
	}
	
	
	@Title("This test will delete the newly added student")
	@Test
	public void test004()
	{
//		student = new StudentClass();
//		courses = new ArrayList<String>();
//		
//		courses.add("CS");
//		courses.add("ELE");
//	
//		student.setId(1);
//		student.setFirstName("firstname22");
//		student.setLastName("lastname1");
//		student.setEmail("email1@email.com");
//		student.setProgramme("testprog1");
//		student.setCourses(courses);
		
//		SerenityRest.rest().given().
//		contentType(ContentType.JSON).
//		log().all().
//		when().
//		body(student).
//		delete("/"+studentId).
//		then().log().all();
		
		steps.deleteStudentById(studentId);
		
		SerenityRest.rest().given().
//		contentType(ContentType.JSON).
//		log().all().
		when().
		get("/"+studentId).
		then().log().all().
		statusCode(404).
		spec(ReusableSpecification.getGenericResponseSpec());;
		
	}
	
	
}
