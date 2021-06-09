package com.studentapp.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentapp.base.TestBase;
import com.studentapp.model.CreateStudentRequestPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MyFirstTest extends TestBase{

	@Test(enabled=false)
	void getAllStudents() {
//		RequestSpecification requestSpec = RestAssured.given();
//		
//		Response response =requestSpec.get("http://localhost:8085/student/list");
//		response.prettyPrint();
//		
//		ValidatableResponse validableResponse = response.then();
//		validableResponse.statusCode(200);
		
		RestAssured.given()
		.expect()
		.statusCode(200)
		.when()
		.get("/list").then().log().all();
		
	}
	
	@Test(enabled=false)
	void getSingleCSStudent() {
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("programme", "Computer Science");
		params.put("limit", 1);
		
		Response response =given()
		.queryParams(params)
		.when()
		.get("/list");
		
		response.prettyPrint();
	}
	
	@Test
	void getTheFirstStudent() {
		
		Response resp = given()
		.pathParam("id", 1)
		.when()
		.get("/{id}");
		
		System.out.println(resp.asPrettyString());
		
		CreateStudentRequestPojo sObject= resp.getBody().as(CreateStudentRequestPojo.class);	
		Assert.assertEquals(sObject.getEmail(), "egestas.rhoncus.Proin@massaQuisqueporttitor.org");
				
		//RestAssured.reset();
	}
}
