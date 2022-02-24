package com.tests.simpleCRUDWithTekarchApp;

import com.test.constants.Endpoints;
import com.test.helpers.UserServiceHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class UpdateUserDataTest extends UserServiceHelper{
	
		LoginToApi lapi = new LoginToApi();
		Endpoints ep = new Endpoints();
		GetUserDataTest get = new GetUserDataTest();
		
		public void updateUser()
		{
			String tokenvalue=getToken();
			Header apiheader=setToken();
			Object obj = setUpdateUserData();
			System.out.println("Updating user");
			Response res=RestAssured.given().header(apiheader).contentType(ContentType.JSON)
					.body(obj)
					.when()
					.put(ep.UPDATE_DATA);
			res.then().assertThat().statusCode(200);
			res.then().assertThat().contentType(ContentType.JSON);
			System.out.println("After updating user");
			get.getUser();
		}
}