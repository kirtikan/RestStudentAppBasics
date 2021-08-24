package com.studentapp.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentapp.base.TestBase;
import com.studentapp.model.CreateStudentRequestPojo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

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
		params.put("limit", 2);
		
		Response response =given()
		.queryParams(params).log().all()
		.when()
		.get("/list");
		
		response.prettyPrint();
	}
	
	@Test
	void getTheFirstStudent() {

//		Response resp = given()
//		.pathParam("id", 1).log().all()
//		.when()
//		.get("/{id}");	
//		System.out.println(resp.asPrettyString());
		
		//CreateStudentRequestPojo sObject= resp.getBody().as(CreateStudentRequestPojo.class);	
		//Assert.assertEquals(sObject.getEmail(), "egestas.rhoncus.Proin@massaQuisqueporttitor.org");
			
		
		RequestSpecification rs = given().pathParam("id", 1).log().all();
		
		ValidatableResponse rv = rs.when().get("/{id}").then();
		rv.body("id", equalTo(1));
		rv.body("courses", hasItems("Accounting","Statistics"));
		
		
		
//		RequestSpecBuilder rSB = new RequestSpecBuilder();
//		rSB.setBaseUri("http://localhost").setPort(8081).setBasePath("/student").addPathParam("id", 1);		
//		RequestSpecification rsNew =	rSB.build();
//		
//		ResponseSpecBuilder rSBNew = new ResponseSpecBuilder();
//		rSBNew.expectStatusCode(200).expectBody("id", equalTo(1)).expectBody("courses", hasItems("Accounting","Statistics"));
		
		
//		ResponseSpecification rNew=rSBNew.build();
//		
//		given().spec(rsNew).log().all().when().get("/{id}").then().spec(rNew).log().all();
		
	
		//RestAssured.reset();
	}
}
