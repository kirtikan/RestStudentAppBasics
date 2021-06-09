package com.studentapp.request;

import java.util.ArrayList;
import java.util.List;

import com.studentapp.model.CreateStudentRequestPojo;

public class RequestDetails {

	public static CreateStudentRequestPojo createRequest() {
		CreateStudentRequestPojo createObject = new CreateStudentRequestPojo();
		
		List<String> courses = new ArrayList<String>();
		courses.add("C++");
		courses.add("JAVA");
		
		createObject.setFirstName("Sonia");
		createObject.setLastName("Developer");
		createObject.setEmail("sonia@gmail.com");
		createObject.setProgramme("Computer Science");
		createObject.setCourses(courses);
		
		return createObject;
	}
	
}
