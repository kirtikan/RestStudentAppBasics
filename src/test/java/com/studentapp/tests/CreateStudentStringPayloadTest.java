package com.studentapp.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.studentapp.base.TestBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class CreateStudentStringPayloadTest extends TestBase{

	@Test
	void createNewStudent() {
	
		String payload = "{\"firstName\":\"test2\",\"lastName\":\"User\",\"email\":\"test2@gmail.com\",\"programme\":\"Computer Science\",\"courses\":[\"C++\",\"JAVA\"]}";
		
		given()
		.contentType(ContentType.JSON)
		.body(payload)
		.when()
		.post()
		.then()
		.statusCode(201);
		
		
		Response  resp =(Response) given().contentType(ContentType.JSON).body(payload);
		//given().header(ContentType, )
	}
}
