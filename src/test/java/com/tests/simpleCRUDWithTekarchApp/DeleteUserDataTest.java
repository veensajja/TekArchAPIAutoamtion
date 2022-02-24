package com.tests.simpleCRUDWithTekarchApp;

import com.test.constants.Endpoints;
import com.test.helpers.UserServiceHelper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class DeleteUserDataTest extends UserServiceHelper{

	LoginToApi lapi = new LoginToApi();
	Endpoints ep = new Endpoints();
	GetUserDataTest get = new GetUserDataTest();
	
	public void deleteUser()
	{
		String tokenvalue=getToken();
		Header apiheader=setToken();
		Object obj = setUpdateUserData();
		System.out.println("Deleting user");
		Response res=RestAssured.given().header(apiheader).contentType(ContentType.JSON)
				.body(obj)
				.when()
				.delete(ep.DELETE_DATA);
		res.then().assertThat().statusCode(200);
		res.then().assertThat().contentType(ContentType.JSON);
		System.out.println("After deleting user");
		get.getUser();
	}
}
