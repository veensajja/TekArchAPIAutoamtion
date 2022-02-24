package com.test.helpers;



import com.test.constants.Endpoints;
import com.test.models.AddUserPOJO;
import com.test.models.LoginObjectPOJO;

import com.test.utils.Utils;
import com.test.models.UserPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class UserServiceHelper {

	 static Response response;
	 static String token;
	 static int statuscode;
	 static Header apiheader;
	 static String idvalue;
	 static String useridvalue;
	 static String username=Utils.getConfigProperty("username");
	 static String password =Utils.getConfigProperty("password");
	 static String accountno=Utils.getConfigProperty("accountno");
	static 	String deptno =Utils.getConfigProperty("deptno");
	static	String salary =Utils.getConfigProperty("salary");
	static String pincode =Utils.getConfigProperty("pincode");
	static 	String updateddeptno =Utils.getConfigProperty("updateddeptno");
	static	String updatedsalary =Utils.getConfigProperty("updatedsalary");	
	
	public static String getBaseUri()
	{
		String baseURI=Utils.getConfigProperty("baseUrl");
		return baseURI;
	}
	
	public static Response LoginToApplication()
	{
		
		LoginObjectPOJO ob = new LoginObjectPOJO();
		ob.setUsername(username);
		ob.setPassword(password);
		response = RestAssured.given().contentType("application/json").body(ob).when().post(Endpoints.LOGIN);
		return response;
		
	}
		
	
	public static String getToken()
	{
		//response = LoginToApplication();
		token = response.jsonPath().get("[0].token");
		return token;
	}
	public static void getStatusCode()
	{
		
		response = LoginToApplication();
		statuscode=response.getStatusCode();
		System.out.println("extracted status="+statuscode);
		response.then().assertThat().statusCode(201);
	
	}
	
	public static Object setCreateUserData()
	{
		AddUserPOJO obj = new AddUserPOJO();
		obj.setAccountno(accountno);
		obj.setDepartmentno(deptno);
		obj.setSalary(salary);
		obj.setPincode(pincode);
		return obj;
	}
	
	public static Object setUpdateUserData()
	{
		AddUserPOJO obj = new AddUserPOJO();
		obj.setAccountno(accountno);
		obj.setDepartmentno(updateddeptno);
		obj.setSalary(updatedsalary);
		obj.setPincode(pincode);
		obj.setId(idvalue);
		obj.setUserid(useridvalue);
		return obj;
	}
	
	
	public static void getUserData(Response response)
	{
		
	UserPOJO[] listOfUsers=response.as(UserPOJO[].class);//deserilization
	System.out.println("Total no of records "+listOfUsers.length);
	String accno = listOfUsers[0].getAccountno();
	System.out.println("First account no "+accno);
	String depno = listOfUsers[0].getDepartmentno();
	System.out.println("First dep value "+depno);
	String salary = listOfUsers[0].getSalary();
	System.out.println("First salary "+salary);
	idvalue=listOfUsers[0].getId();
	System.out.println("First id value "+idvalue);
	useridvalue=listOfUsers[0].getUserid();
	System.out.println("First id uservalue "+useridvalue);
	}
	
	
	public static Header setToken()
	{
		String tokenvalue = getToken();
		apiheader=new Header("token",tokenvalue );
		return apiheader;
	}
		
}
