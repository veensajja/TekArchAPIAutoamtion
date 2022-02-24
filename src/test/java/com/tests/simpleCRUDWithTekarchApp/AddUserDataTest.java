package com.tests.simpleCRUDWithTekarchApp;

import com.test.constants.Endpoints;
import com.test.helpers.UserServiceHelper;
import com.test.utils.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class AddUserDataTest extends UserServiceHelper {

	LoginToApi lapi = new LoginToApi();
	Endpoints ep = new Endpoints();

	public void createUser()
	{
		String tokenvalue=getToken();
		Header apiheader=setToken();
		Object obj = setCreateUserData();
		System.out.println("Adding user");
		Response response=RestAssured.given().header(apiheader).contentType("application/json")
			.body(obj)
			.when()
			.post(ep.ADD_DATA);
		response.then().assertThat().statusCode(201);
		response.then().assertThat().contentType(ContentType.JSON);
	
}
}

