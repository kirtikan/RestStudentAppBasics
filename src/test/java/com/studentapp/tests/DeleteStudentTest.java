package com.studentapp.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.studentapp.base.TestBase;

import io.restassured.http.ContentType;
public class DeleteStudentTest extends TestBase{


	@Test
	void deleteStudent() {
		given()
		.contentType(ContentType.JSON)
		.when()
		.delete("/108")
		.then()
		.statusCode(204);
		
	}
}
