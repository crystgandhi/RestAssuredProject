package restAssuredBasics;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponse {
	
	//@Test
	public void testJSONResponse() {
		given()
		.contentType("ContentType.JSON")
		.when()
		.get("http://localhost:3000/store")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json")
		.body("book[3].title", equalTo("The Lord of the Rings"))
		;
		
	}
	
	//@Test
	public void testJSONResponse2() {
	Response res=	given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/store");
	Assert.assertEquals(res.statusCode(), 200);
	Assert.assertEquals(res.getHeader("Content-Type"),"application/json");
	String bookName=res.jsonPath().get("book[2].title").toString();
		System.out.println(bookName);
	}
	
	@Test
	public void testJSONResponse3() {
		Response res = given().contentType(ContentType.JSON).when().get("http://localhost:3000/store");
		JSONObject jsonObject = new JSONObject(res.toString());
		for (int k = 0; k < jsonObject.getJSONArray("book").length(); k++) {
			String bookTitle = jsonObject.getJSONArray("book").getJSONObject(k).get("title").toString();
			System.out.println(bookTitle);
		}
	}

}
