package com.tests.simpleCRUDWithTekarchApp;

import java.util.LinkedHashMap;

import com.test.constants.Endpoints;
import com.test.helpers.UserServiceHelper;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class GetUserDataTest extends UserServiceHelper{

	LoginToApi lapi = new LoginToApi();
	Endpoints ep = new Endpoints();
	
	public void getUser()
	{
		String tokenvalue=getToken();
		Header apiheader=setToken();
		System.out.println("Getting user data");
		Response response=RestAssured.given().header(apiheader)
				.when()
				.get(ep.GET_DATA);
		response.then().assertThat().statusCode(200);
		response.then().assertThat().contentType(ContentType.JSON);
		getUserData(response);

	}
	
	
}


	
		
		
		