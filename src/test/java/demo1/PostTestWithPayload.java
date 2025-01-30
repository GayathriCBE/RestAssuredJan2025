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

public class PostTestWithPayload {
	
	@Test
	public void test1() {
		String BaseURI="https://petstore.swagger.io/v2";
		File Postpayload=new File("src/test/resources/Payload/Example.json");
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(Postpayload)
		.when()
		.post(BaseURI+"/pet")
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
