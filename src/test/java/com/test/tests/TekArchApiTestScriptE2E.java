package com.test.tests;

import org.testng.annotations.Test;

import com.test.helpers.UserServiceHelper;
import com.tests.simpleCRUDWithTekarchApp.AddUserDataTest;
import com.tests.simpleCRUDWithTekarchApp.DeleteUserDataTest;
import com.tests.simpleCRUDWithTekarchApp.GetUserDataTest;
import com.tests.simpleCRUDWithTekarchApp.LoginToApi;
import com.tests.simpleCRUDWithTekarchApp.UpdateUserDataTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TekArchApiTestScriptE2E {
	LoginToApi loginApi = new LoginToApi();
	AddUserDataTest createUserApi = new AddUserDataTest();
	GetUserDataTest getUserApi = new GetUserDataTest();
	UpdateUserDataTest updateUserApi = new UpdateUserDataTest();
	DeleteUserDataTest deleteUserApi = new DeleteUserDataTest();
	
	@Test(priority=1)
	public void Login()
	{
	
		loginApi.Login();
	}
	
	@Test(priority=2)
	public void createUser()
	{
	
		createUserApi.createUser();
	}
	
	@Test(priority=3)
	public void getUser()
	{
		getUserApi.getUser();
		
	}
	
	@Test(priority=4)
	public void updateUser()
	{
		updateUserApi.updateUser();
		
	}
	
	
	@Test(priority=5)
	public void deleteUser()
	{
		deleteUserApi.deleteUser();
		
	}
}
