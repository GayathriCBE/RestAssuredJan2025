package demo1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetTest {
	@Test(enabled=false)
	public void test() {
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.statusCode());
		System.out.println(response.asString());
		System.out.println(response.asPrettyString());
		System.out.println(response.statusLine());
		
		int responseCode=response.statusCode();
		Assert.assertEquals(responseCode, 200);
		
	}
	@Test
	public void test1() {
		given().when()
		.get("https://reqres.in/api/users?page=2")
		.then().statusCode(200)
		        .body("data[0].id", equalTo(7)) //checking assertion which will not show in console if it pass
		        .body("support.url", containsString("https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral"))
		        .body("data.first_name", hasItems("Michael","Tobias"))
				.log().all();		// it will display response body
	}	
	

}
