package com.studentapp.tests;


import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentapp.base.TestBase;
import com.studentapp.model.CreateStudentRequestPojo;
import com.studentapp.model.CreateStudentResponsePojo;
import com.studentapp.request.RequestDetails;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class CreateStudentPojoPayloadTest extends TestBase {


	@Test
	void createNewStudentwithPojo() {
		
		CreateStudentRequestPojo student =RequestDetails.createRequest();
		
		Response respose =given()
				.contentType(ContentType.JSON).body(student).log().all().when().post();
		
		System.out.println(respose.asPrettyString());
		
		//respose.getHeader("ContentType");
		//respose.then().assertThat();
		//respose.then().
		
		Assert.assertEquals(respose.getStatusCode(), 201);
		respose.getBody();
		
		CreateStudentResponsePojo responseObject = respose.getBody().as(CreateStudentResponsePojo.class);
		Assert.assertEquals(responseObject.getMsg(), "Student added");
		
		//RestAssured.reset();
		
	}
}
