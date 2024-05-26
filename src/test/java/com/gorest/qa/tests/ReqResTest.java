package com.gorest.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gorest.qa.base.BaseTest;
import com.gorest.qa.rest.RestClient;
import com.gorest.qa.utilities.HttpStatusCode;

public class ReqResTest extends BaseTest{
	

	
RestClient rest;
	
	@BeforeMethod
	public void setRestClient() {
		 rest=new RestClient(properties, baseURI);
	}
	
	
	
	@Test
	public void getAllUserFromReqRes() {
		
		//RestClient restClient=new RestClient(properties, baseURI);
		
		rest.doGET(REQRES_BASHPATH, false,true)
		.then().log().all().assertThat().statusCode(HttpStatusCode.OK_200.getCode());
		
	
	}


}
