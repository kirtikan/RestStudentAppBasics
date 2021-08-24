package com.studentapp.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentapp.base.TestBase;
import com.studentapp.model.CreateStudentRequestPojo;
import com.studentapp.model.CreateStudentResponsePojo;
import com.studentapp.request.RequestDetails;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateStudentPojoPayloadTest extends TestBase {
	
	
	@Test
	void updateStudent() {
		
		CreateStudentRequestPojo student =RequestDetails.createRequest();

		Response response = given()
		.contentType(ContentType.JSON)
		.body(student).log().all()
		.when()
		.put("/105");
		
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		CreateStudentResponsePojo responeObject = response.getBody().as(CreateStudentResponsePojo.class);
		Assert.assertEquals(responeObject.getMsg(), "Student Updated");
	}

}
