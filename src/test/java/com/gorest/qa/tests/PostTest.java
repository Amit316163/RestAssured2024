package com.gorest.qa.tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gorest.qa.base.BaseTest;
import com.gorest.qa.pojo.UserLombok;
import com.gorest.qa.rest.RestClient;
import com.gorest.qa.utilities.ExcelReader;
import com.gorest.qa.utilities.HttpStatusCode;
import com.gorest.qa.utilities.StringUtils;

public class PostTest extends BaseTest {
	RestClient rest;
	
	ExcelReader excel=new ExcelReader();
	
	@BeforeMethod
	public void setClient() {
		
		rest=new RestClient(properties, baseURI);
	}
	
	
	@DataProvider
	public Object[][] createUserData() {
		
		return new Object[][] {
			{"Rohit","male","active"},
			{"Sanu","female","active"},
			{"Sneha","female","inactive"},
		};
		
	}
	
	@DataProvider
	public Object[][] createUserExcelData() {
		
		try {
			return excel.excelReaderTest(GoREST_SHEETNAME);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Test(dataProvider ="createUserData",enabled=false )
	public void createSingleUser(String name,String gender,String status) {
		
		UserLombok user=new UserLombok(name, gender, StringUtils.randomEmailID(), status);
		
		
		rest.doPost(GOREST_BASHPATH, "Json", user,true, true)
		.then().log().all().assertThat().statusCode(HttpStatusCode.CREATED_201.getCode());
	}
	
	@Test(dataProvider ="createUserExcelData" )
	public void createSingleExcelUser(String name,String gender,String status) {
		
		UserLombok user=new UserLombok(name, gender, StringUtils.randomEmailID(), status);
		
		
		rest.doPost(GOREST_BASHPATH, "Json", user,true, true)
		.then().log().all().assertThat().statusCode(HttpStatusCode.CREATED_201.getCode());
	}

}
