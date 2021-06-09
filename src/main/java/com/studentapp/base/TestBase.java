package com.studentapp.base;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class TestBase {
	
	@BeforeMethod
	public static void init() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
	}
	
	@AfterMethod
	public static void tearDown() {
		
	}
	
	
}
