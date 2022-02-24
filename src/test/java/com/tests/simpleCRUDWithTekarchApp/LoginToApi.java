package com.tests.simpleCRUDWithTekarchApp;

import com.test.helpers.UserServiceHelper;
import com.test.utils.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginToApi extends UserServiceHelper
{

	public void Login()
	{
	RestAssured.baseURI = getBaseUri();
	System.out.println("Logging into TekArch");
	getStatusCode();
	String tokenvalue=UserServiceHelper.getToken();
	System.out.println("extracted token="+tokenvalue);

		
	}
	
}
