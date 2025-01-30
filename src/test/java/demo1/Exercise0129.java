package demo1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class Exercise0129 {
//	static String body=" ";
			@Test
			public void testAuthorizationSuccessMessage() {
				String BaseURI="https://demo.testfire.net/api/login";
				File Postpayload=new File("src/test/resources/Payload/Example3.json");
				String body= given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(Postpayload)
				.when()
				.post(BaseURI)
				.then()
				.extract()
				.path("Authorization");
				System.out.println(body);
			}
			
//			@Test
//			public void getAuthorizationtoken() {
//				given().when()
//				.accept(ContentType.JSON)
//				.header("Authorization", body)
//				.get("https://demo.testfire.net/api/login")
//				.then()
//				.statusCode(200)
//				.log().all();
//			   
//			}
			
			
			

			
}
