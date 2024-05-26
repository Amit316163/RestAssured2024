package com.gorest.qa.base;



import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.gorest.qa.config.ConfigurationManger;
import com.gorest.qa.rest.RestClient;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class BaseTest {
	
	public static final String GOREST_BASHPATH="/public/v2/users";
	public static final String REQRES_BASHPATH="/api/users";
	public static final String FAKESTORE_BASHPATH="/products";
	public static final String GoREST_SHEETNAME="Sheet4";
	
	 protected ConfigurationManger config;
	 protected Properties properties;
	 protected RestClient restClient;
	 public  String baseURI;
	 
	
	 @BeforeTest
	 @Parameters({"baseURI"})
	public void setUP(String baseURI) {
		 
		 RestAssured.filters(new AllureRestAssured());
		
		 config=new ConfigurationManger();
		
		 properties= config.init();
		
		//String baseURI=properties.getProperty("baseURI");
		 
		this.baseURI=baseURI;
		
		// restClient=new RestClient(properties, baseURI);
	}
	
	
	

}
