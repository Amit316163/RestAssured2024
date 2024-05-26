package com.gorest.qa.tests;



import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gorest.qa.base.BaseTest;
import com.gorest.qa.rest.RestClient;
import com.gorest.qa.utilities.HttpStatusCode;


public class GetTest extends BaseTest {
	RestClient rest;
	
	
	
	@BeforeMethod
	public void setRestClient() {
		 rest=new RestClient(properties, baseURI);
	}
	
	
	
	@Test
	public void getAllUserData() {
		
		//RestClient restClient=new RestClient(properties, baseURI);
		
		rest.doGET(GOREST_BASHPATH,true, true)
		.then().log().all().assertThat().statusCode(HttpStatusCode.OK_200.getCode());
		
	
	}
	
	
	@Test
	public void getSingleUser() {
		
		//RestClient restClient=new RestClient();
		
		rest.doGET(GOREST_BASHPATH+"/6928312",true, true)
		.then().log().all().assertThat().statusCode(HttpStatusCode.OK_200.getCode());
		
	
	}
	
	@Test
	public void getUserQueryParams() {
		
	//	RestClient restClient=new RestClient();
		
		Map<String,String> params=new HashMap<String,String>();
		params.put("name", "Gangesh Varman");
		params.put("gender", "female");
		
		rest.doGET(GOREST_BASHPATH, null, params,true, true)
		.then().log().all().assertThat().statusCode(HttpStatusCode.OK_200.getCode());
		
	
	}

}
