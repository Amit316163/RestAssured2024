package com.gorest.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gorest.qa.base.BaseTest;
import com.gorest.qa.pojo.UserLombok;
import com.gorest.qa.rest.RestClient;
import com.gorest.qa.utilities.StringUtils;

public class EndToEndTest extends BaseTest{
	
	RestClient rest;
	
	@BeforeMethod
	public void setRestClient() {
		 rest=new RestClient(properties, baseURI);
	}
	
	@Test
	public void createSingleUser() {
		
		UserLombok user=new UserLombok("Ishwar", "male", StringUtils.randomEmailID(), "active");
		
		
	int id=	rest.doPost(GOREST_BASHPATH, "Json", user,true, true)
		.then().log().all().assertThat().statusCode(201).extract().path("id");
	
	System.out.println("Id ==>"+id);
	
	//RestClient restGet=new RestClient(properties, baseURI);
	rest.doGET(GOREST_BASHPATH+id, true,true).then().log().all().statusCode(200);
	
	}
	
	

}
