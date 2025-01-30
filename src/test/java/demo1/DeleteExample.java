package demo1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class DeleteExample {
	
	@Test
	public void test1() {
		given()
		.when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204)
		.log().all();
		
	}


	@Test
	public void test2() {
		given()
		.header("accept","application/json")
		.header("api_key", "Special_Key")
		.when()
		.delete("https://petstore.swagger.io/v2/pet/9223372036854775807")
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
